import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};
    static int[][] result;
    static boolean[][] visit;
    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(result[i][j] == 0) {

                    if(go(i, j) == 1) count ++;

                } else if(result[i][j] == 1) {
                    count ++;
                }
            }
        }

        System.out.println(count);
    }

    static int go(int r, int c) {
        visit[r][c] = true;
        if(result[r][c] != 0) {
            visit[r][c] = false;
            return result[r][c];
        }

        char ch = arr[r][c];

        int dir;
        if(ch == 'U') dir = 3;
        else if(ch == 'R')  dir = 0;
        else if(ch == 'D') dir = 1;
        else dir = 2;

        int nr = r + dirRow[dir];
        int nc = c + dirCol[dir];

        int ret ;
        if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
            ret = 1;
        } else if(visit[nr][nc]){
            ret = -1;
        } else ret = go(nr, nc);

        result[r][c] = ret;
        visit[r][c] = false;
        return result[r][c];
    }
}