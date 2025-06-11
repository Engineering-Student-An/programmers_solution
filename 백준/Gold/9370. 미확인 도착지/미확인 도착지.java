import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, t;
    static List<Info>[] adjacencyList;
    static long[] result;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < testcase; T++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            adjacencyList = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());

                adjacencyList[u].add(new Info(v, value));
                adjacencyList[v].add(new Info(u, value));
            }

            result = new long[n+1];
            check = new boolean[n+1];
            for (int i = 0; i <= n; i++) {
                result[i] = Long.MAX_VALUE;
            }
            result[s] = 0;

            dijkstra(s, g, h);

            PriorityQueue<Integer> ans = new PriorityQueue<>();
            for (int i = 0; i < t; i++) {
                int node = Integer.parseInt(br.readLine());

                if(check[node]) ans.add(node);
            }

            while (!ans.isEmpty()) {
                sb.append(ans.poll()).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra(int s, int g, int h) {

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.value, o2.value));
        queue.add(new Info(s, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.node] < now.value) continue;

            for (Info next : adjacencyList[now.node]) {
                if(result[now.node] != Long.MAX_VALUE && result[next.node] > result[now.node] + next.value) {
                    result[next.node] = result[now.node] + next.value;
                    queue.add(new Info(next.node, result[next.node]));

                    if((now.node == g && next.node == h) || (now.node == h && next.node == g)) check[next.node] = true;
                    else check[next.node] = check[now.node];
                } else if(result[now.node] != Long.MAX_VALUE && result[next.node] == result[now.node] + next.value && !check[next.node]) {
                    if(check[now.node] || (now.node == g && next.node == h) || (now.node == h && next.node == g)) {
                        check[next.node] = true;
                        queue.add(new Info(next.node, result[next.node]));
                    }
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