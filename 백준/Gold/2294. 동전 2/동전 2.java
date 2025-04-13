import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] result = new int[k + 1];
        for (int i = 1; i < k + 1; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                int coin = coins[j];
                if (coin <= k && i - coin >= 0 && result[i - coin] != Integer.MAX_VALUE) {
                    result[i] = Math.min(result[i], result[i - coin] + 1);
                }
            }
        }

        System.out.println((result[k] == Integer.MAX_VALUE) ? -1 : result[k]);
    }
}