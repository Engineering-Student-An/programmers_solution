import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = gcd(a, b);

        System.out.println(gcd);
        System.out.println(gcd * (a / gcd) * (b / gcd));
    }

    static int gcd(int a, int b) {
        if(b > a) {
            int temp = b;
            b = a;
            a = temp;
        }

        while(true) {
            if(a % b == 0) return b;

            int mod = a % b;
            a = b;
            b = mod;
        }
    }
}