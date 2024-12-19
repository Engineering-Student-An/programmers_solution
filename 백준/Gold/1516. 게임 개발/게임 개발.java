import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] timeList = new int[n+1];
        ArrayList<Integer>[] adjacencyList = new ArrayList[n+1];
        int[] inDegree = new int[n+1];

        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= n; i++) {
            timeList[i] = scanner.nextInt();
        
            while(true) {
                int start = scanner.nextInt();
                if(start == -1) break;

                adjacencyList[start].add(i);
                inDegree[i]++;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        int[] result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                queue.add(new Node(i, timeList[i]));
            }
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for (Integer i : adjacencyList[node.index]) {
                inDegree[i] --;
                if(inDegree[i] == 0) queue.add(new Node(i, timeList[i]));
                result[i] = Math.max(result[node.index] + timeList[node.index], result[i]);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + timeList[i]);
        }
    }

    static class Node {
        int index;
        int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}