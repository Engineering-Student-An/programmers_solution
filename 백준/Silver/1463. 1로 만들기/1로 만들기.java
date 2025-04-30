import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] result = new long[n+1];
        for (int i = 2; i <= n; i++) {
            long one = (i%3 == 0) ? result[i/3] + 1 : Long.MAX_VALUE;
            long two = (i%2 == 0) ? result[i/2] + 1 : Long.MAX_VALUE;
            long three = result[i-1] + 1;

            result[i] = Math.min(Math.min(one, two), three);
        }

        System.out.println(result[n]);
    }
}