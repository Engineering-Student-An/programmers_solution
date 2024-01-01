import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int s_row = scanner.nextInt();
            int s_col = scanner.nextInt();
            int e_row = scanner.nextInt();
            int e_col = scanner.nextInt();

            int sum = 0;
            for (int j = s_row; j <= e_row; j++) {
                for (int k = s_col; k <= e_col; k++) {
                    sum += arr[j][k];
                }
            }
            System.out.println(sum);
        }
    }
}