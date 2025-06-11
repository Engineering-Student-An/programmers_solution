import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] coin = {25, 10, 5, 1};
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();

            int[] count = new int[4];
            for (int j = 0; j < 4; j++) {
                count[j] += (n / coin[j]);
                n %= coin[j];
            }

            for (int j = 0; j < 4; j++) {
                System.out.print(count[j] + " ");
            }
            System.out.println();
        }
    }
}