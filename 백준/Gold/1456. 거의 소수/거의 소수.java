import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();

        int sqrt = (int) Math.sqrt(b.longValue());

        int result = 0;

        boolean[] isPrime = new boolean[sqrt+1];

        for (int i = 2; i <= sqrt; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= sqrt; i++) {
            if(isPrime[i]) {
                for (int j = i*2; j <= sqrt; j+=i) {
                    isPrime[j] = false;
                }


                int j = 2;
                while(BigInteger.valueOf((long) Math.pow(i, j)).compareTo(b) <= 0) {
                    if(BigInteger.valueOf((long) Math.pow(i, j)).compareTo(a) >= 0) {
                        result ++;
                    }
                    j ++;
                }
            }
        }

        System.out.println(result);
    }
}