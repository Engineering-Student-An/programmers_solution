import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] coin = {300, 60, 10};

        int n = scanner.nextInt();
        int[] count = new int[3];

        if(n % 10 != 0) {
            System.out.println(-1);
        } else {

            for (int i = 0; i < 3; i++) {
                count[i] += (n / coin[i]);
                n %= coin[i];
            }

            for (int i = 0; i < 3; i++) {
                System.out.print(count[i] + " ");
            }
        }
    }
}