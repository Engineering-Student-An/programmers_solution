import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        Integer[] chk = new Integer[n-x+1];
        for (int i = x; i <= n; i++) {
            chk[i-x] = sum[i] - sum[i-x];
        }

        Arrays.sort(chk, Collections.reverseOrder());

        if(chk[0] == 0) {
            System.out.println("SAD");
        } else {
            int days = 0;
            for (int i = 0; i < n-x+1; i++) {
                if(Objects.equals(chk[i], chk[0])) {
                    days ++;
                } else {
                    break;
                }
            }
            System.out.println(chk[0]);
            System.out.println(days);
        }
    }
}