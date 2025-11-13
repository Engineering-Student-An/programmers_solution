import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long ans = 0;
        for (int i = 1; i <= n/3; i++) {
            for (int j = i; j <= (n - i) / 2; j++) {
                int k = n - i - j;
                if(k >= j && i + j > k) {
                    ans ++;
                }
            }
        }

        System.out.println(ans);
    }
}