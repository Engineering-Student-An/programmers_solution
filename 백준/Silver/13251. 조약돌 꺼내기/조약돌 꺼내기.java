import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        int[] colors = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            colors[i] = scanner.nextInt();
            sum += colors[i];
        }

        int k = scanner.nextInt();
        double result = 0.0;
        for (int i = 0; i < m; i++) {
            double now = 1.0;
            for (int j = 0; j < k; j++) {
                now *= (double) (colors[i] - j) / (sum - j);
            }
            result += now;
        }

        System.out.println(result);
    }
}