import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Info middle;
        if(k == 0) middle = new Info(0, 0);
        else {
            int r = (k % m == 0) ? k / m - 1 : k / m;
            int c = (k % m == 0) ? m-1 : k % m - 1;
            middle = new Info(r, c);
        }
        int[][] result = new int[n][m];
        for (int i = 0; i <= middle.r; i++) result[i][0] = 1;
        for (int i = 0; i <= middle.c; i++) result[0][i] = 1;
        for (int i = 1; i <= middle.r; i++) {
            for (int j = 1; j <= middle.c; j++) {
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }

        int before = result[middle.r][middle.c];
        for (int i = middle.r; i < n; i++) result[i][middle.c] = before;
        for (int i = middle.c; i < m; i++) result[middle.r][i] = before;
        for (int i = middle.r + 1; i < n; i++) {
            for (int j = middle.c + 1; j < m; j++) {
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }

        System.out.println(result[n-1][m-1]);
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}