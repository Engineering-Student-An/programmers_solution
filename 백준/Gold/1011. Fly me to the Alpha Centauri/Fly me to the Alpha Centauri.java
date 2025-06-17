import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tt = 0; tt < T; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            b -= a;

            long sum = 0;
            int i = 1;
            int check = 0;
            long ans = 0;
            while(true) {
                sum += i;
                check ++;
                ans ++;
                if(sum > b) {
                    if(check == 1) i --;
                    break;
                } else if(sum == b) {
                    break;
                }

                if(check == 2) {
                    i ++;
                    check = 0;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}