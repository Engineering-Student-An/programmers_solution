import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long before = 0;
        for (int i = m - 1; i >= 0; i--) {
            int now = Integer.parseInt(st.nextToken());
            before += (long) (now * Math.pow(A, i));
        }
        
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(true) {
            if((long) (before / (Math.pow(B, start))) == 0) break;

            start ++;
        }

        start --;
        for (int i = start; i >= 0; i--) {
            sb.append((long) (before / Math.pow(B, i))).append(" ");
            before %= (long) Math.pow(B, i);
        }

        System.out.println(sb);
    }
}