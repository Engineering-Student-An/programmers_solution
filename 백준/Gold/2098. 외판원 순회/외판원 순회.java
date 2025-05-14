import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1 << n];
        System.out.println(tsp(0, 1));
    }

    static int tsp(int current, int visit) {

        // 이미 연산 완료한 경우
        if(dp[current][visit] != 0) return dp[current][visit];

        // 다 방문하고 출발 노드로 돌아가야 하는 경우
        if(visit == (1 << n) - 1) return (cost[current][0] == 0) ? 20000000 : cost[current][0];

        int min = 20000000;
        for (int i = 0; i < n; i++) {
            // 방문하지 않았고, 갈 수 있는 경로
            if((visit & (1 << i)) == 0 && cost[current][i] != 0) {
                min = Math.min(min, tsp(i, (visit | (1 << i))) + cost[current][i]);
            }
        }

        return dp[current][visit] = min;
    }
}