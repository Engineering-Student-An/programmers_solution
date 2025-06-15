import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static PriorityQueue<Integer>[] adjacencyList;
    static boolean[] visit;
    static int[] count;
    static int c = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        adjacencyList = new PriorityQueue[n+1];
        for (int i = 0; i < n + 1; i++) {
            adjacencyList[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        visit = new boolean[n+1];
        count = new int[n+1];
        count[start] = c ++;
        visit[start] = true;
        dfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(count[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int i) {

        while (!adjacencyList[i].isEmpty()) {
            Integer next = adjacencyList[i].poll();
            if (!visit[next]) {
                count[next] = c++;
                visit[next] = true;
                dfs(next);
            }
        }
    }
}