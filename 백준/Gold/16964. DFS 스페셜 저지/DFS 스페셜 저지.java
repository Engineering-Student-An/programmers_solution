import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, s;
    static int[] seq;
    static boolean[] visit;
    static PriorityQueue<Info>[] adjacencyList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] edge = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        seq = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int node = Integer.parseInt(st.nextToken());
            seq[node] = i;
        }

        adjacencyList = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        }

        for (int i = 0; i < n - 1; i++) {
            int u = edge[i][0];
            int v = edge[i][1];

            adjacencyList[u].add(new Info(v, seq[v]));
            adjacencyList[v].add(new Info(u, seq[u]));
        }

        visit = new boolean[n + 1];
        visit[1] = true;

        s = 1;
        System.out.println(dfs(1) ? 1 : 0);
    }

    static boolean dfs(int now) {

        while (!adjacencyList[now].isEmpty()) {
            Info next = adjacencyList[now].poll();
            if(visit[next.node]) continue;

            visit[next.node] = true;

            if(next.count == s + 1) {
                s ++;
                return dfs(next.node);
            }
            else return false;
        }

        return true;
    }

    static class Info {
        int node, count;

        public Info(int node, int count) {
            this.node = node;
            this.count = count;
        }
    }
}