import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        BigInteger sum = BigInteger.ZERO;
        for(int i=0;i<n;i++){
            sum = sum.add(BigInteger.valueOf(arr[i]*(n-i)));
        }
        System.out.println(sum);
    }
}