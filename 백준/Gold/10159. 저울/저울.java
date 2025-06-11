import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] result = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                result[i][j] = (i!=j) ? Integer.MAX_VALUE : 0;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            result[u][v] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if(result[s][k] != Integer.MAX_VALUE && result[k][e] != Integer.MAX_VALUE) {
                        result[s][e] = Math.min(result[s][e], result[s][k] + result[k][e]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if(result[i][j] == Integer.MAX_VALUE && result[j][i] == Integer.MAX_VALUE) count ++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}