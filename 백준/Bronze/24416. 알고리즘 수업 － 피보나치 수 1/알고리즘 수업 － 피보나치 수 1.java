import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] fibo = new long[n+1];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= n; i++) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }

        System.out.println(fibo[n] + " " + (n-2));
    }
}