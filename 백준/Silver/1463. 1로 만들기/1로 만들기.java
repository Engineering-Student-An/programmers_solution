import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] arr = new long[n+1];
        arr[n] = 0;

        for (int i = n-1; i > 0; i--) {
            long one = (i * 3 <= n) ? arr[i * 3] + 1 : Long.MAX_VALUE;
            long two = (i * 2 <= n) ? arr[i * 2] + 1: Long.MAX_VALUE;
            long three = arr[i+1] + 1;

            long result = Math.min(one, Math.min(two, three));

            arr[i] = result;
        }

        System.out.println(arr[1]);
    }
}