import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] result = new long[n+1][k+1];
        for (int i = 1; i <= k; i++) {
            result[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                result[i][j] = ((result[i-1][j] % 1000000000) + (result[i][j-1] % 1000000000)) % 1000000000;
            }
        }

        System.out.println(result[n][k]);
    }
}