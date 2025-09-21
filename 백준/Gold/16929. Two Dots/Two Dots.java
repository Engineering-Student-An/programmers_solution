import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static boolean isFound = false;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - 'A';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit = new boolean[n][m];
//                visit[i][j] = true;
                dfs(1, i, j, i, j);
                if(isFound) break;
            }

            if(isFound) break;
        }

        System.out.println((isFound) ? "Yes" : "No");
    }

    static void dfs(int count, int originRow, int originCol, int r, int c) {

        if(count > 4 && originRow == r && originCol == c) {
            isFound = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dirRow[i];
            int nc = c + dirCol[i];

            if(nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == arr[originRow][originCol] && !visit[nr][nc]) {
                visit[nr][nc] = true;
                dfs(count + 1, originRow, originCol, nr, nc);
                visit[nr][nc] = false;

                if(isFound) return;
            }
        }

    }
}