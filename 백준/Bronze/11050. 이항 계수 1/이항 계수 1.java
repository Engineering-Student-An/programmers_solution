import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long[][] arr = new long[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        System.out.println(arr[n][k]);
    }
}