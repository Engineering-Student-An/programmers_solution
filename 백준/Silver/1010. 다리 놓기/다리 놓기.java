import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long[][] arr = new long[31][31];
        for (int i = 0; i < 31; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < 31; i++) {
            for (int j = 1; j < 31; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }

        int t = scanner.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();

            System.out.println(arr[n][k]);
        }
    }
}