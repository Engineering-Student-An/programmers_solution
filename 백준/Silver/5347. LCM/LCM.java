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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lcs(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static long lcs(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int one = a;
        int two = b;

        while(a > 0) {
            int mod = b % a;
            b = a;
            a = mod;
        }

        return (long) b * (one / b) * (two / b);
    }
}