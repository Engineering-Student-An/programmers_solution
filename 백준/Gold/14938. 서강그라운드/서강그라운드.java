import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, r;
    static int[] items;
    static int[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = (i!=j) ? Integer.MAX_VALUE : 0;
            }
        }


        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            result[u][v] = value;
            result[v][u] = value;
        }

        floydWarshall();

        int max = -1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if(result[i][j] <= m) sum += items[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(result[i][k] != Integer.MAX_VALUE && result[k][j] != Integer.MAX_VALUE) {
                        result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                    }
                }
            }
        }
    }
}