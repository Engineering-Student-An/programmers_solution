import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[][] result = new long[n+1][10];
        for (int i = 1; i < 10; i++) {
            result[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0) {
                    result[i][j] = result[i-1][1] % 1000000000;
                } else if(j == 9) {
                    result[i][j] = result[i-1][8] % 1000000000;
                } else {
                    result[i][j] = (result[i-1][j-1] % 1000000000 + result[i-1][j+1] % 1000000000) % 1000000000;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += (result[n][i] % 1000000000);
        }
        System.out.println(ans % 1000000000);
    }
}