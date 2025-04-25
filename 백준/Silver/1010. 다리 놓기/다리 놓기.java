import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[][] comb = new long[30][30];
        for (int i = 0; i < 30; i++) {
            comb[i][0] = 1;
        }

        for (int i = 1; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                comb[i][j] = comb[i-1][j] + comb[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int tt = 0; tt < t; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(comb[m][n]).append("\n");
        }

        System.out.print(sb);
    }
}