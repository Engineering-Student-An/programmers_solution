import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] arr = new long[4][100001];
        final long mod = 1000000009;

        arr[1][1] = 1;
        arr[2][2] = 1;
        arr[1][3] = 1;
        arr[2][3] = 1;
        arr[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            arr[1][i] = (arr[2][i-1] % mod + arr[3][i-1] % mod) % mod;
            arr[2][i] = (arr[1][i-2] % mod + arr[3][i-2] % mod) % mod;
            arr[3][i] = (arr[1][i-3] % mod + arr[2][i-3] % mod) % mod;
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            long result = (arr[1][n] % mod + arr[2][n] % mod + arr[3][n] % mod) % mod;
            sb.append(result).append("\n");

        }

        System.out.print(sb);
    }
}