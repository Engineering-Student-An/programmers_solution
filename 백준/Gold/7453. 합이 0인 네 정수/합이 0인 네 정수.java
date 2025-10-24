import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[4][n];

        sum = new long[n * n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Long.parseLong(st.nextToken());
            }
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[index ++] = arr[2][i] + arr[3][j];
            }
        }

        Arrays.sort(sum);

        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long dest = (arr[0][i] + arr[1][j]) * -1;
                count += upperBound(dest) - lowerBound(dest);
            }
        }

        System.out.println(count);
    }

    static int lowerBound(long num) {
        int l = 0, r = sum.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (sum[m] < num) l = m + 1;
            else r = m;
        }
        return l;
    }

    static int upperBound(long num) {
        int l = 0, r = sum.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (sum[m] <= num) l = m + 1;
            else r = m;
        }
        return l;
    }
}