import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] people;
    static List<Integer>[] adjacencyList;
    static int[][] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[n+1];
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        visit = new boolean[n + 1];
        visit[1] = true;
        result = new int[n + 1][2];
        dfs(1);

        System.out.println(Math.max(result[1][0], result[1][1]));
    }

    static void dfs(int now) {
        result[now][1] = people[now];

        for(Integer next : adjacencyList[now]) {
            if(!visit[next]) {
                visit[next] = true;
                dfs(next);

                result[now][0] += Math.max(result[next][0], result[next][1]);
                result[now][1] += result[next][0];
            }
        }
    }
}