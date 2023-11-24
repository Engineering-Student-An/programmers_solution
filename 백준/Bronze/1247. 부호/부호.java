import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.ZERO;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < 3; i++) {
            int n = scanner.nextInt();
            BigInteger sum = new BigInteger("0");
            for (int j = 0; j < n; j++) {
                BigInteger x = scanner.nextBigInteger();
                 sum = sum.add(x);
            }
            if(sum.compareTo(ZERO) == 0) {
                System.out.println(0);
            } else if (sum.compareTo(ZERO) == 1){
                System.out.println("+");
            } else{
                System.out.println("-");
            }
        }
    }
}
