import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Info>[] adjacencyList;
    static long[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(new Info(v, value));
        }

        result = new long[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = Long.MAX_VALUE;
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append((result[i] == Long.MAX_VALUE) ? "INF" : result[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> Long.compare(a.value, b.value));
        result[start] = 0;
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info current = pq.poll();

            if (result[current.node] < current.value) {
                continue; // 이미 더 짧은 경로를 찾음
            }

            for (Info info : adjacencyList[current.node]) {
                long newDist = result[current.node] + info.value;

                if (newDist < result[info.node]) {
                    result[info.node] = newDist;
                    pq.add(new Info(info.node, newDist));
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