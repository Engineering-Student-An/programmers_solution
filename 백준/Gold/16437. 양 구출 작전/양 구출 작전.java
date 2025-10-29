import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] visit;
    static List<Integer>[] adjacencyList;
    static long[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        count = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char s = st.nextToken().charAt(0);
            long c = Long.parseLong(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            adjacencyList[i].add(u);
            adjacencyList[u].add(i);

            if(s == 'S') count[i] = c;
            else count[i] = c * -1;
        }

        visit = new boolean[n + 1];
        visit[1] = true;
        System.out.println(dfs(1));

    }

    static long dfs(int now) {
        long totalSheep = 0;

        for (int next : adjacencyList[now]) {
            if (!visit[next]) {
                visit[next] = true;
                totalSheep += dfs(next);
            }
        }

        if (count[now] > 0) { // 양
            totalSheep += count[now];
        } else { // 늑대
            totalSheep = Math.max(0, totalSheep + count[now]); // 잡아먹힘
        }

        return totalSheep;
    }
}