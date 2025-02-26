import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        long[][][] arr = new long[n+1][l+1][r+1];

        arr[1][1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    arr[i][j][k] = (arr[i-1][j-1][k] % 1000000007)
                            + (arr[i-1][j][k-1] % 1000000007)
                            + (arr[i-1][j][k] * (i-2) % 1000000007);
                }
            }
        }

        System.out.println(arr[n][l][r] % 1000000007);
    }
}