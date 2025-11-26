import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int sum = 0;
            int max = -1;
            int count = 0;
            int index = -1;
            for (int i = 0; i < n; i++) {
                int now = Integer.parseInt(br.readLine());

                if(now > max) {
                    max = now;
                    index = i + 1;
                    count = 1;
                } else if(now == max) {
                    count ++;
                }

                sum += now;
            }

            if(count > 1) sb.append("no winner").append("\n");
            else {
                if(max > sum / 2) sb.append("majority winner ").append(index).append("\n");
                else sb.append("minority winner ").append(index).append("\n");
            }

        }

        System.out.print(sb);


    }
}