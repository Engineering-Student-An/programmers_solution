import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Info>[] adjacencyList;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testcase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            adjacencyList = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                adjacencyList[v].add(new Info(u, time));
            }

            result = new int[n+1];
            for (int i = 1; i <= n; i++) {
                result[i] = Integer.MAX_VALUE;
            }

            dijkstra(start);

            int count = 0;
            int max = -1;
            for (int i = 1; i <= n; i++) {
                if(result[i] != Integer.MAX_VALUE) {
                    count ++;
                    max = Math.max(result[i], max);
                }
            }

            sb.append(count).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        result[start] = 0;

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        queue.add(new Info(start, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.node] < now.time) continue;

            for (Info next : adjacencyList[now.node]) {
                if(result[next.node] > result[now.node] + next.time) {
                    result[next.node] = result[now.node] + next.time;
                    queue.add(new Info(next.node, result[next.node]));
                }
            }
        }
    }

    static class Info {
        int node, time;

        public Info(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}