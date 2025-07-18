import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer>[] adjacencyList;
    static int[][] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        result = new int[n+1][2];
        visit = new boolean[n+1];

        dp(1);

        System.out.println(Math.min(result[1][0], result[1][1]));
    }

    static void dp(int node) {
        visit[node] = true;

        result[node][1] = 1;

        for (Integer next : adjacencyList[node]) {
            if(!visit[next]) {
                dp(next);

                result[node][0] += result[next][1];
                result[node][1] += Math.min(result[next][0], result[next][1]);
            }
        }
    }
}
