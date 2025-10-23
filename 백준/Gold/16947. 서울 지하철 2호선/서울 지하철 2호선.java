import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static boolean found;
    static boolean[] isCycle, visit;
    static List<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        isCycle = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if(!isCycle[i]) {
                visit = new boolean[n + 1];
                visit[i] = true;
                found = false;
                dfs(i, i, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(isCycle[i]) sb.append(0).append(" ");
            else sb.append(bfs(i)).append(" ");
        }

        System.out.println(sb);
    }

    static class Info {
        int node, distance;

        public Info(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static int bfs(int node) {
        visit = new boolean[n + 1];
        visit[node] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(node, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (Integer next : adjacencyList[now.node]) {
                if(!visit[next]) {
                    if(isCycle[next]) return now.distance + 1;
                    visit[next] = true;
                    queue.add(new Info(next, now.distance + 1));
                }
            }
        }

        return -1;
    }

    static void dfs(int start, int now, int count) {
        for (Integer next : adjacencyList[now]) {
            if(count >= 3 && next == start) {
                found = true;
                isCycle[now] = true;
                return;
            }

            if(!visit[next]) {
                visit[next] = true;
                dfs(start, next, count + 1);
                visit[next] = false;
            }

            if(found) {
                isCycle[now] = true;
                return;
            }
        }
    }
}