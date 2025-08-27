import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) coins[i] = Integer.parseInt(st.nextToken());

            int k = Integer.parseInt(br.readLine());
            int[][] count = new int[n + 1][k + 1];
            count[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    if(coins[i] > j) count[i][j] = count[i - 1][j];
                    else count[i][j] = count[i - 1][j] + count[i][j - coins[i]];
                }
            }

            sb.append(count[n][k]).append("\n");
        }

        System.out.print(sb);
    }
}