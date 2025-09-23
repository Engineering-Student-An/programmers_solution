import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static long[][][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0 : 가로, 1 : 세로, 2 : 대각선
        result = new long[3][n][n];
        for (int i = 1; i < n; i++) {
            if(arr[0][i] == 1) break;
            result[0][0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(arr[i][j] == 1) continue;

                // 가로
                result[0][i][j] += (result[0][i][j - 1] + result[2][i][j - 1]);

                // 세로
                result[1][i][j] += (result[1][i - 1][j] + result[2][i - 1][j]);

                if(arr[i-1][j] == 1 || arr[i][j-1] == 1) continue;

                // 대각선
                result[2][i][j] += (result[0][i - 1][j - 1] + result[1][i - 1][j - 1] + result[2][i - 1][j - 1]);
            }
        }

        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += result[i][n - 1][n - 1];
        }
        System.out.println(sum);
    }
}