import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            int day = 1;
            while (sum <= n) {
                sum *= 4;
                day ++;
            }

            sb.append(day).append("\n");
        }

        System.out.print(sb);
    }
}

// 1 2 3 4 5 6 => 21
// 13 11 15 13 17 15 => 84