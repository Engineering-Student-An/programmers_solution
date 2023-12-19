import java.math.BigInteger;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger[] arr = new BigInteger [n+1];
        arr[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1].multiply(BigInteger.valueOf(i));
        }
        BigInteger ten = new BigInteger("10");
        int count = 0;
        while(true){
            if(!arr[n].remainder(BigInteger.TEN).equals(BigInteger.ZERO)) break;
            count++;
            arr[n] = arr[n].divide(BigInteger.TEN);
        }
        System.out.println(count);
    }
}