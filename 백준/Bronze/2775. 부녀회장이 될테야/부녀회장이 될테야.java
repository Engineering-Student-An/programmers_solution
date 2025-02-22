import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        
        int[][] arr = new int[15][15];
        for (int i = 1; i <= 14; i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        for (int tc = 0; tc < t; tc++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();

            System.out.println(arr[k][n]);
        }
    }
}