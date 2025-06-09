import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[][] arr = new long[n+1][10];
        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i-1][k] % 10007;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += arr[n][i];
        }

        System.out.println(sum % 10007);
    }
}