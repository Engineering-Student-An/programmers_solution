import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adjacencyList = new ArrayList[v+1];
        for (int i = 0; i <= v; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjacencyList[from].add(new Node(to, value));
        }

        final int INF = 99999999;
        int[] result = new int[v+1];
        for (int i = 1; i <= v; i++) {
            if(i!=start) result[i] = INF;
        }

        boolean[] visit = new boolean[v+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            visit[poll] = true;

            for (Node node : adjacencyList[poll]) {
                result[node.ind] = Math.min(result[node.ind], result[poll] + node.value);
            }

            int min = INF;
            int ind = 0;
            for (int i = 1; i <= v; i++) {
                if(!visit[i] && min > result[i]) {
                    min = result[i];
                    ind = i;
                }
            }
            if(ind == 0) break;
            queue.add(ind);
        }

        for (int i = 1; i <= v; i++) {
            System.out.println((result[i] != INF) ? result[i] : "INF");
        }
    }

    static class Node {
        int ind;
        int value;

        public Node(int ind, int value) {
            this.ind = ind;
            this.value = value;
        }
    }
}

