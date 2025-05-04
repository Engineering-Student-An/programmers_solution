import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        long[][][] arr = new long[n+1][l+1][r+1];
        long mod = 1000000007;
        arr[1][1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    arr[i][j][k] = (arr[i-1][j-1][k] + arr[i-1][j][k-1] + (i-2) * arr[i-1][j][k]) % mod;
                }
            }
        }

        System.out.println(arr[n][l][r] % mod);
    }
}