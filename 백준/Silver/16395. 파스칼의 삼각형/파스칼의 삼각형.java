import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }

        System.out.println(arr[n-1][m-1]);
    }
}