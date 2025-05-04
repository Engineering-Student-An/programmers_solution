import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");

        int n = split.length - 1;
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = split[i].charAt(0) - '0';
        }

        int[][][] dp = new int[n + 1][5][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        if(n > 0) {
            dp[1][nums[1]][0] = 2;
            dp[1][0][nums[1]] = 2;
        }

        for (int i = 1; i < n; i++) {
            int next = nums[i+1];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(dp[i][j][k] != Integer.MAX_VALUE) {
                        if(next == j || next == k) {
                            dp[i + 1][j][k] = Math.min(dp[i][j][k] + 1, dp[i + 1][j][k]);
                        } else {
                            dp[i + 1][j][next] = Math.min(dp[i][j][k] + count(k, next), dp[i + 1][j][next]);
                            dp[i + 1][next][k] = Math.min(dp[i][j][k] + count(j, next), dp[i + 1][next][k]);
                        }
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result = Math.min(dp[n][i][j], result);
            }
        }

        System.out.println((result == Integer.MAX_VALUE) ? 0 : result);
    }

    static int count(int now, int next) {
        if(now == next) return 1;
        if(now == 0) return 2;
        if(Math.abs(now - next) == 2) return 4;
        return 3;
    }
}
