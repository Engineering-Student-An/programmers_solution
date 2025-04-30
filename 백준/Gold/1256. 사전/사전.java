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
        long k = Long.parseLong(st.nextToken());

        long[][] combination = new long[n + m + 1][n + m + 1];
        for (int i = 0; i < n + m + 1; i++) {
            combination[i][0] = 1;
        }

        for (int i = 1; i <= n + m; i++) {
            for (int j = 1; j <= n + m; j++) {
                long next = combination[i - 1][j] + combination[i - 1][j - 1];
                if(next > 1000000000) {
                    next = 1000000001;
                }
                combination[i][j] = next;
            }
        }

        if (k > combination[n + m][m]) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            int size = n + m;
            for (int i = 0; i < size; i++) {

                long next = combination[n + m - 1][m];
                if (k <= next) {
                   sb.append("a");
                    n--;
                } else {
                    k -= next;
                    sb.append("z");
                    m--;
                }
            }

            System.out.println(sb);
        }
    }
}