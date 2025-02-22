import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] arr = new int[n+1][k+1];

        for (int i = 0; i < n + 1; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {

                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }

        System.out.println(arr[n][k]);
    }
}