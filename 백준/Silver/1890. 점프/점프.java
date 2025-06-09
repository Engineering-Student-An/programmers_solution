import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] result = new long[n][n];
        result[0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(i - j == arr[0][j]) result[0][i] += result[0][j];
                if(i - j == arr[j][0]) result[i][0] += result[j][0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < j; k++) {
                    if(j - k == arr[i][k]) result[i][j] += result[i][k];
                }
                for (int k = 0; k < i; k++) {
                    if(i - k == arr[k][j]) result[i][j] += result[k][j];
                }
            }
        }

        System.out.println(result[n-1][n-1]);
    }
}