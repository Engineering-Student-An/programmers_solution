import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            visit[i] = true;
            dfs(i, i, 0, 1);
            visit[i] = false;
        }

        System.out.println(ans);
    }

    static void dfs(int start, int index, int value, int count) {
        if(count == n) {
            if(arr[index][start] != 0) {
                ans = Math.min(ans, value + arr[index][start]);
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i] && arr[index][i] != 0) {
                visit[i] = true;
                dfs(start, i, value + arr[index][i], count + 1);
                visit[i] = false;
            }
        }
    }
}