import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, ans, wlen;
    static String word;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};
    static int[][][] fin;
    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        word = br.readLine();

        wlen = word.length();
        fin = new int[wlen][n][m];

        for (int i = 0; i < wlen; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    fin[i][j][l] = Integer.MIN_VALUE;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == word.charAt(0)) {
                    ans += find(0, i, j);
                }
            }
        }

        System.out.println(ans);
    }

    static int find(int ind, int r, int c) {

        if(fin[ind][r][c] != Integer.MIN_VALUE) return fin[ind][r][c];

        if(ind == wlen - 1) return fin[ind][r][c] = 1;

        fin[ind][r][c] = 0;
        for (int dir = 0; dir < 4; dir++) {
            for (int count = 1; count <= k; count++) {
                int nr = r + count * dirRow[dir];
                int nc = c + count * dirCol[dir];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == word.charAt(ind + 1)) {
                    fin[ind][r][c] += find(ind + 1, nr, nc);
                }
            }
        }

        return fin[ind][r][c];
    }
}