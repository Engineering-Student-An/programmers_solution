import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        result = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = (i == j) ? 0 : Long.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            result[s][e] = Math.min(result[s][e], value);
        }

        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(result[i][j] != Long.MAX_VALUE ? result[i][j] : 0).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
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