import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            int[][] sum = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    sum[i][j] = Integer.MAX_VALUE;
                }
            }

            sum[0][k] = arr[0][k];

            // 2 ~ n
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int l = 1; l <= 2; l++) {
                        if(sum[i-1][(j + l) % 3] == Integer.MAX_VALUE) continue;
                        sum[i][j] = Math.min(sum[i][j], sum[i - 1][(j + l) % 3] + arr[i][j]);
                    }
                }
            }
            // n
            for (int i = 1; i <= 2; i++) {
                result = Math.min(result, sum[n - 1][(k + i) % 3]);
            }

        }
        System.out.println(result);
    }
}