import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tt = 0; tt < t; tt++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] result = new int[3][n+1];
            for (int i = 1; i <= n; i++) {
                result[0][i] = Math.max(result[0][i - 1], Math.max(result[1][i - 1], result[2][i - 1]));
                result[1][i] = Math.max(result[0][i - 1], result[2][i - 1]) + arr[0][i];
                result[2][i] = Math.max(result[0][i - 1], result[1][i - 1]) + arr[1][i];
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                max = Math.max(result[i][n], max);
            }

            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}