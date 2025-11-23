import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] result = new long[m + 1];
        result[0] = n;

        for (int i = 1; i <= m; i++) {
            result[i] = result[i-1] + (result[i-1] * 5 / 100);

            if (i >= 3) result[i] = Math.max(result[i], result[i - 3] + (result[i - 3] * 20 / 100));
            if(i >= 5) result[i] = Math.max(result[i], result[i - 5] + (result[i - 5] * 35 / 100));
        }

        System.out.println(result[m]);
    }
}