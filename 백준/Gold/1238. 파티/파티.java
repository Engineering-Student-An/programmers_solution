import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Info>[] adjacencyList;
    static long[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(new Info(v, value));
        }

        result = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        long max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, (result[i][destination] + result[destination][i]));
        }

        System.out.println(max);
    }

    static void dijkstra(int start) {

        for (int i = 1; i <= n; i++) {
            result[start][i] = Long.MAX_VALUE;
        }

        result[start][start] = 0;

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.value, o2.value));
        queue.add(new Info(start, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[start][now.node] < now.value) continue;

            for (Info next : adjacencyList[now.node]) {
                if(result[start][next.node] > result[start][now.node] + next.value) {
                    result[start][next.node] = result[start][now.node] + next.value;
                    queue.add(new Info(next.node, result[start][next.node]));
                }
            }
        }
    }

    static class Info {
        int node;
        long value;

        public Info(int node, long value) {
            this.node = node;
            this.value = value;
        }
    }
}