import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Info>[] adjacencyList;
    static boolean[] visit;
    static int result = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(new Info(v, value));
            adjacencyList[v].add(new Info(u, value));
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n+1];
            visit[i] = true;
            dfs(i, 0);
        }

        System.out.println(result);
    }

    static void dfs(int node, int value) {
        for (Info info : adjacencyList[node]) {
            if(!visit[info.node]) {
                visit[info.node] = true;
                dfs(info.node, value + info.value);
                visit[info.node] = false;
            }
        }

        result = Math.max(value, result);
    }

    static class Info {
        int node;
        int value;

        public Info(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}