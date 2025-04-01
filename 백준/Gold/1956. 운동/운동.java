import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = Long.MAX_VALUE;
            }
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            result[u][v] = value;
        }

        floydWarshall();

        long min = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if(result[i][i] != Long.MAX_VALUE) {
                min = Math.min(min, result[i][i]);
            }
        }
        System.out.println((min == Long.MAX_VALUE) ? -1 : min);
    }

    static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(result[i][k] != Long.MAX_VALUE && result[k][j] != Long.MAX_VALUE) {
                        result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                    }
                }
            }
        }
    }
}