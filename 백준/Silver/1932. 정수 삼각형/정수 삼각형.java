import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] result = new int[n][n];
        result[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            result[i][0] = arr[i][0] + result[i-1][0];
            result[i][i] = arr[i][i] + result[i-1][i-1];
            for (int j = 1; j < i; j++) {
                result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]) + arr[i][j];
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if(max < result[n-1][i]) max = result[n-1][i];
        }

        System.out.println(max);
    }
}