import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long count = 0;
            for (long i = 5; i <= n; i*=5) {
                count += (n / i);
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}