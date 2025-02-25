import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[][] arr = new long[n+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % 10007;
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[n-i][i] % 10007;
        }

        System.out.println(result % 10007);
    }
}