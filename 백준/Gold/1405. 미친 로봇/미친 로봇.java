import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static double[] percentage;
    static int[] dirRow = {0, 0, 1, -1}, dirCol = {1, -1, 0, 0};
    static boolean[][] visit;
    static double result = 0.0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        percentage = new double[4];
        for (int i = 0; i < 4; i++) {
            percentage[i] = (Integer.parseInt(st.nextToken()) / 100.0);
        }

        visit = new boolean[50][50];
        visit[25][25] = true;

        dfs(25, 25, 0, 1);

        System.out.println(result);
    }

    static void dfs(int r, int c, int count, double mul) {
        if(count == n) {
            result += mul;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(percentage[i] == 0.0) continue;

            int nr = r + dirRow[i];
            int nc = c + dirCol[i];

            if(!visit[nr][nc]) {
                visit[nr][nc] = true;
                dfs(nr, nc, count + 1, mul * percentage[i]);
                visit[nr][nc] = false;
            }
        }
    }
}