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

        boolean isPossible = true;
        for (int i = 0; i < m; i++) {
            int c = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int before = Integer.MAX_VALUE;
            for (int j = 0; j < c; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(isPossible && before > now) {
                    before = now;
                } else {
                    isPossible = false;
                }
            }
        }

        System.out.println((isPossible) ? "Yes" : "No");
    }
}