import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());

            long[] arr = new long[m + 1];
            arr[0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= m; j++) {
                    arr[j] += arr[j - coins[i]];
                }
            }
            sb.append(arr[m]).append("\n");
        }


        System.out.print(sb);
    }
}