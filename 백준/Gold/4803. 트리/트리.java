import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] adjacencyList;
    static boolean[] visit;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int time = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            adjacencyList = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            int[][] edgeList = new int[m][2];
            for(int i = 0; i < m; i ++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                edgeList[i][0] = u;
                edgeList[i][1] = v;

                adjacencyList[u].add(v);
                adjacencyList[v].add(u);
            }

            parent = new int[n+1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            visit = new boolean[n + 1];
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if(!visit[i]) bfs(i);
            }

            int[] edgeCount = new int[n + 1];
            for (int i = 0; i < m; i++) {
                edgeCount[find(edgeList[i][0])] ++;
            }

            int[] nodeCount = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                nodeCount[find(i)] ++;
            }

            for (int i = 1; i <= n; i++) {
                if(nodeCount[i] == edgeCount[i] + 1) count ++;
            }

            sb.append("Case ").append(time).append(": ");

            if(count > 1) sb.append("A forest of ").append(count).append(" trees.").append("\n");
            else if(count == 1) sb.append("There is one tree.").append("\n");
            else sb.append("No trees.").append("\n");

            time ++;
        }

        System.out.print(sb);
    }

    static void bfs(int node) {

        visit[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : adjacencyList[now]) {
                if(!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                    union(now, next);
                }
            }
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[Math.max(a, b)] = Math.min(a, b);
        }
    }
}