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
            int[] arr = new int[n + 1];
            int[][] result = new int[n + 1][n + 1];
            int[] prefixSum = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    max = Math.max(max, prefixSum[i] - prefixSum[j]);
                }
            }

            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}