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
        int start = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] adjacencyList = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        int[] visit = new int[n+1];
        visit[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int count = 2;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            while(!adjacencyList[now].isEmpty()) {
                Integer next = adjacencyList[now].poll();

                if(visit[next] == 0) {
                    visit[next] = count ++;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visit[i]).append("\n");
        }

        System.out.print(sb);
    }
}