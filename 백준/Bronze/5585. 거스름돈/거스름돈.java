import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] coin = {500, 100, 50, 10, 5, 1};

        int n = scanner.nextInt();
        int count = 0;
        n = 1000 - n;
        for (int i = 0; i < 6; i++) {
            count += (n / coin[i]);
            n %= coin[i];
        }

        System.out.println(count);
    }
}