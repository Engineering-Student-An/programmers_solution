import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[101][101];
        for (int i = 0; i < n; i++) {
            int s_row = scanner.nextInt();
            int s_col = scanner.nextInt();
            int e_row = scanner.nextInt();
            int e_col = scanner.nextInt();
            for (int j = s_row; j <= e_row; j++) {
                for (int k = s_col; k <= e_col; k++) {
                    arr[j][k] ++;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if(arr[i][j] > m) count++;
            }
        }

        System.out.println(count);
    }
}