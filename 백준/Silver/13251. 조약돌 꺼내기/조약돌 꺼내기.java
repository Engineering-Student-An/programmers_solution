import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        int sum = 0;
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = scanner.nextInt();
            sum += num[i];
        }

        int k = scanner.nextInt();

        double result = 0.0;
        for (int i = 0; i < m; i++) {
            double now = 1.0;
            for (int j = num[i]; j > num[i]-k; j--) {
                now *= (double) (j) / (sum + j - num[i]);
            }
            result += now;
        }

        System.out.println(result);
    }
}