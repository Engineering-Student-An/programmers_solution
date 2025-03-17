import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;
    static int[] nextRow = {0, 1, 0, -1};
    static int[] nextCol = {1, 0, -1, 0};
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visit;
    static boolean[] alphaVisit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];
        alphaVisit = new boolean[26];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (line.charAt(j) - 'A');
            }
        }

        visit[0][0] = true;
        alphaVisit[arr[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(result);
    }

    static void dfs(int i, int j, int count) {

        for (int k = 0; k < 4; k++) {
            int ni = i + nextRow[k];
            int nj = j + nextCol[k];

            if(ni >= 0 && ni < n && nj >= 0 && nj < m && !visit[ni][nj] && !alphaVisit[arr[ni][nj]]) {
                visit[ni][nj] = true;
                alphaVisit[arr[ni][nj]] = true;
                dfs(ni, nj, count + 1);
                visit[ni][nj] = false;
                alphaVisit[arr[ni][nj]] = false;
            }
        }

        result = Math.max(result, count);
    }
}