import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] result = new long[n+1];
        result[1] = 0;
        if(n > 1) result[2] = 1;
        long mod = 1000000000;

        for (int i = 3; i <= n; i++) {
            result[i] = ((i-1) * (result[i-2] + result[i-1])) % mod;
        }

        System.out.println(result[n]);
    }
}