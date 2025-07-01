import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            int[] now = new int[m+1];
            now[1] = i;
            seq(i, 1, now);
        }

        System.out.print(sb);
    }

    static void seq(int num, int count, int[] now) {

        if(count == m) {
            for (int i = 1; i <= m; i++) {
                sb.append(now[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = num; i <= n; i++) {
            now[count + 1] = i;
            seq(i, count + 1, now);
        }
    }
}