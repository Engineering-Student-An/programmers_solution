import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        BigInteger min= BigInteger.valueOf(1000001);
        BigInteger max= BigInteger.valueOf(0);

        for(int i=0;i<n;i++) {
            int m = scanner.nextInt();
            if(min.compareTo(BigInteger.valueOf(m)) > 0){
                min = BigInteger.valueOf(m);
            }
            if(max.compareTo(BigInteger.valueOf(m)) < 0){
                max = BigInteger.valueOf(m);
            }
        }

        System.out.println(min.multiply(max));

    }
}