import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        BigInteger[] arr = new BigInteger[n+1];

        arr[1] = BigInteger.ONE;
        if(n>1) arr[2] = BigInteger.TWO;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1].add(arr[i-2]).remainder(BigInteger.valueOf(15746));
        }

        System.out.println(arr[n]);
    }
}
