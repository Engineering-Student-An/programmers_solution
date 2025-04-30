import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] result = new long[n+1];
        result[1] = 1;
        if(n > 1) result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = (result[i-2] + result[i-1]) % 10007;
        }

        System.out.println(result[n]);
    }
}