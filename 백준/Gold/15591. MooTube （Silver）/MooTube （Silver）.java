import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Info>[] adjacencyList;
    static int[][] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(new Info(v, value));
            adjacencyList[v].add(new Info(u, value));
        }

        distance = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int j = 1; j <= n; j++) {
                if(v != j && distance[v][j] >= k) count ++;
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int start) {
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));
        queue.add(new Info(start, distance[start][start]));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(distance[start][now.node] < now.value) continue;

            for (Info next : adjacencyList[now.node]) {
                if(distance[start][next.node] == Integer.MAX_VALUE && next.node != start) {
                    distance[start][next.node] = Math.min(next.value, distance[start][now.node]);
                    queue.add(new Info(next.node, distance[start][next.node]));
                }
            }
        }
    }

    static class Info {
        int node, value;

        public Info(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}