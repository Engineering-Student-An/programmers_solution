import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[][] arr = new long[n+1][3];
        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i][0] = (arr[i-1][0] % 9901 + arr[i-1][1] % 9901 + arr[i-1][2] % 9901) % 9901;
            arr[i][1] = (arr[i-1][0] % 9901 + arr[i-1][2] % 9901) % 9901;
            arr[i][2] = (arr[i-1][0] % 9901 + arr[i-1][1] % 9901) % 9901;
        }

        long count = 0;
        for (int i = 0; i < 3; i++) {
            count += arr[n][i] % 9901;
        }

        System.out.println(count % 9901);
    }
}