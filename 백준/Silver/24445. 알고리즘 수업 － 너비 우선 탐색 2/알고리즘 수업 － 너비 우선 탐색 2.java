import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] adjacencyList = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        int count = 2;
        int[] result = new int[n + 1];
        result[k] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            while(!adjacencyList[now].isEmpty()) {
                Integer next = adjacencyList[now].poll();
                if(result[next] == 0) {
                    result[next] = count ++;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.print(sb);
    }
}