import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean[] visit = new boolean[n+1];

        ArrayList<Integer>[] arr = new ArrayList[n+1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int st = scanner.nextInt();
            int end = scanner.nextInt();
            arr[st].add(end);
            arr[end].add(st);
        }

        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if(!visit[i]) {
                count ++;
                Queue<Integer> queue = new LinkedList<>(arr[i]);
                visit[i] = true;

                while(!queue.isEmpty()) {
                    int v = queue.poll();
                    if(!visit[v]){
                        visit[v] = true;
                        queue.addAll(arr[v]);
                    }

                }
            }
        }

        System.out.println(count);
    }

}

