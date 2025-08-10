import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] fibo = new int[n - 1];
        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i < n-1; i++) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }

        int mulA = fibo[n-3];
        int mulB = fibo[n-2];

        boolean isFin = false;
        for (int b = 1; mulB * b < k ; b++) {
            int rem = k - mulB * b;
            int a = rem / mulA;
            if(rem % mulA == 0 && a <= b) {
                System.out.println(a);
                System.out.println(b);
                isFin = true;
            }
            if(isFin) break;
        }
    }
}