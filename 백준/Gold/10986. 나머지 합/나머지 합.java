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

        long[] arr = new long[n+1];
        long[] sum = new long[n+1];
        int[] count = new int[m];

        st = new StringTokenizer(br.readLine());
        count[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum[i] = ((sum[i-1] % m) + (arr[i] % m)) % m;

            count[(int) sum[i]] ++;
        }

        long[][] combination = new long[1000002][3];
        for (int i = 0; i <= 1000001; i++) {
            combination[i][0] = 1;
        }
        for (int i = 1; i <= 1000001; i++) {
            for (int j = 1; j < 3; j++) {
                combination[i][j] = combination[i-1][j] + combination[i-1][j-1];
            }
        }

        long result = 0;
        for (int i = 0; i < m; i++) {
            if(count[i] != 0) {
                result += combination[count[i]][2];
            }
        }

        System.out.println(result);
    }
}