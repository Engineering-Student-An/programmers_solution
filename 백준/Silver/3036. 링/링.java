import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n - 1; i++) {
            int next = Integer.parseInt(st.nextToken());
            sb.append(gcd(num, next)).append("\n");
        }

        System.out.print(sb);
    }

    static String gcd(int a, int b) {
        int first = a;
        int second = b;

        if(b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(a % b != 0) {
            int mod = a % b;

            a = b;
            b = mod;
        }

        return (first / b) + "/" + (second/b);
    }
}