import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int N, M;
    static boolean[] blocked;     // 리조트에 갈 수 없는 날 표시
    static int[][] dp;            // dp[i][j] = i일까지 고려, j장의 쿠폰이 있을 때 최소 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        blocked = new boolean[N + 6];  // 5일권 때문에 여유분
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int day = Integer.parseInt(st.nextToken());
                blocked[day] = true;
            }
        }

        dp = new int[N + 6][101];  // 날짜 + 쿠폰 상태
        for (int i = 0; i <= N + 5; i++) Arrays.fill(dp[i], INF);

        dp[0][0] = 0;  // 시작 상태

        // DP 진행
        for (int day = 0; day < N; day++) {
            for (int coupon = 0; coupon <= 100; coupon++) {
                if (dp[day][coupon] == INF) continue;

                // 1️⃣ 다음 날로 넘어감
                if (blocked[day + 1]) {
                    // 못 가는 날이면 그대로 비용 유지
                    dp[day + 1][coupon] = Math.min(dp[day + 1][coupon], dp[day][coupon]);
                    continue;
                }

                // 2️⃣ 하루권
                dp[day + 1][coupon] = Math.min(dp[day + 1][coupon], dp[day][coupon] + 10000);

                // 3️⃣ 3일권
                dp[day + 3][coupon + 1] = Math.min(dp[day + 3][coupon + 1], dp[day][coupon] + 25000);

                // 4️⃣ 5일권
                dp[day + 5][coupon + 2] = Math.min(dp[day + 5][coupon + 2], dp[day][coupon] + 37000);

                // 5️⃣ 쿠폰으로 하루 이용
                if (coupon >= 3) {
                    dp[day + 1][coupon - 3] = Math.min(dp[day + 1][coupon - 3], dp[day][coupon]);
                }
            }
        }

        // N일까지 고려했을 때 최소비용 구하기
        int answer = INF;
        for (int coupon = 0; coupon <= 100; coupon++) {
            answer = Math.min(answer, dp[N][coupon]);
        }

        System.out.println(answer);
    }
}
