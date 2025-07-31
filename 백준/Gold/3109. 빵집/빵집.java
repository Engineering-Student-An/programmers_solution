import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dirRow = {-1, 0, 1};
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

        int count = 0;
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            visit[i][0] = true;
            if(dfs(i, 0, i+1)) count ++;
        }
        System.out.println(count);
    }

    static boolean dfs(int r, int c, int num) {
        if(c == m-1) return true;

        for (int i = 0; i < 3; i++) {
            int nr = r + dirRow[i];
            int nc = c + 1;

            if(nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == 0 && !visit[nr][nc]) {
                visit[nr][nc] = true;
                if(dfs(nr, nc, num)) return true;
            }
        }

        return false;
    }
}