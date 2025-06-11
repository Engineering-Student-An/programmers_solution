import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] result = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                result[i][j] = (i!=j) ? Integer.MAX_VALUE : 0;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
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
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(result[u][v] != Integer.MAX_VALUE) sb.append(-1);
            else if(result[v][u] != Integer.MAX_VALUE) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}