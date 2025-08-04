import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int n = line.length();
        int[] arr = new int[line.length()];
        for (int i = 0; i < n; i++) {
            arr[i] = line.charAt(i) - '0';
        }

        final int mod = 1000000;
        // 0열 : 묶기 o / 1열 : 묶기 x

        if(n == 1 || arr[0] == 0) {
            System.out.println(arr[0] == 0 ? 0 : 1);
        } else {
            int[][] result = new int[2][n];
            if (arr[0] == 1 || (arr[0] == 2 && arr[1] < 7)) result[0][0] = 1;
            result[1][0] = 1;
            for (int i = 1; i < n; i++) {
                if(arr[i] == 0) {
                    result[1][i] = result[0][i-1];
                    continue;
                }

                if(i < n - 1 && (arr[i] < 2 || (arr[i] == 2 && arr[i + 1] < 7))) result[0][i] = result[1][i - 1] % mod;
                if(arr[i] > 0) result[1][i] = ((result[0][i - 1]) % mod + (result[1][i - 1]) % mod) % mod;
            }

            long ans = (result[0][n - 1] + result[1][n - 1]) % mod;
            if(ans == 0) System.out.println(result[0][n - 2]);
            else System.out.println(ans);
        }
    }
}