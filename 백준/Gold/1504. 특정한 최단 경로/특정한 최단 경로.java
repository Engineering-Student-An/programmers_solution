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

        adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(new Info(v, w));
            adjacencyList[v].add(new Info(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int must1 = Integer.parseInt(st.nextToken());
        int must2 = Integer.parseInt(st.nextToken());

        result = new long[3][n + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = Long.MAX_VALUE;
            }
        }

        dijkstra(1, 0);
        dijkstra(must1, 1);
        dijkstra(must2, 2);


        if ((result[0][must1] == Long.MAX_VALUE || result[1][must2] == Long.MAX_VALUE || result[2][n] == Long.MAX_VALUE) &&
                (result[0][must2] == Long.MAX_VALUE || result[2][must1] == Long.MAX_VALUE || result[1][n] == Long.MAX_VALUE)) {
            System.out.println(-1);
        } else {
            long ans = Math.min(result[0][must1] + result[1][must2] + result[2][n], result[0][must2] + result[2][must1] + result[1][n]);
            System.out.println(ans);
        }

    }

    static void dijkstra(int start, int ind) {
        result[ind][start] = 0;

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.value, o2.value));
        queue.add(new Info(start, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            if (result[ind][now.node] < now.value) continue;

            for (Info next : adjacencyList[now.node]) {
                if (result[ind][next.node] > result[ind][now.node] + next.value) {
                    result[ind][next.node] = result[ind][now.node] + next.value;
                    queue.add(new Info(next.node, result[ind][next.node]));
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