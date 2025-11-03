import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] arr = new long[n + 1];
        if(n >= 1) {
            arr[1] = 1;
            for (int i = 2; i <= n; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
            }
        }

        System.out.println(arr[n]);
    }
}