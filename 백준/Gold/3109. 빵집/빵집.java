import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr, result;
    static int[] dirRow = {-1, 0, 1};
    static boolean isFound;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (line.charAt(j) == '.') ? 0 : 1;
            }
        }

//        remainCol = new int[m];
//        for (int i = 0; i < m; i++) {
//            remainCol[i] = n;
//            for (int j = 0; j < n; j++) {
//                if(arr[j][i] == 1) remainCol[i] --;
//            }
//        }

        result = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            isFound = false;
            result[i][0] = i+1;
//            remainCol[0] --;
            visit[i][0] = true;
            dfs(i, 0, i+1, visit);

//            boolean isFinish = false;
//            for (int j = 0; j < m; j++) {
//                if(remainCol[j] == 0) {
//                    isFinish = true;
//                    break;
//                }
//            }
//            if(isFinish) break;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(result[i][m-1] != 0) count ++;
        }
        System.out.println(count);
    }

    static void dfs(int r, int c, int num, boolean[][] visit) {
        if(c == m-1) {
            isFound = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dirRow[i];
            int nc = c + 1;

            if(nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == 0 && result[nr][nc] == 0 && !visit[nr][nc]) {
                result[nr][nc] = num;
//                remainCol[nc] --;
                visit[nr][nc] = true;
                dfs(nr, nc, num, visit);
                if(isFound) return;
                result[nr][nc] = 0;
//                remainCol[nc] ++;
            }
        }
    }
}