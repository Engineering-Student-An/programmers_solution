import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tt = 0; tt < T; tt++) {
            int n = Integer.parseInt(br.readLine());

            int[] files = new int[n + 1];
            sum = new int[n + 1];         // 누적합 배열
            dp = new int[n + 1][n + 1];   // dp[i][j] : i~j 최소 비용

            // 입력 및 누적합 계산
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + files[i];
            }

            // 구간 길이 len
            for (int len = 2; len <= n; len++) {
                for (int i = 1; i <= n - len + 1; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;

                    // i ~ j 사이의 모든 k에 대해 최소 비용 탐색
                    for (int k = i; k < j; k++) {
                        int cost = dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1];
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }

            sb.append(dp[1][n]).append("\n");
        }
        System.out.print(sb);
    }
}
