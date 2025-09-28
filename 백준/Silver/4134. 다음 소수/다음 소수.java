import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            long n = Long.parseLong(br.readLine());

            if(n > 2 && n % 2 == 0) n ++;
            else if(n < 2) n = 2;

            while(true) {
                if(isPrime(n)) {
                    sb.append(n).append("\n");
                    break;
                }

                n += 2;
            }
        }

        System.out.print(sb);
    }

    static boolean isPrime(long n) {

        for (long i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}