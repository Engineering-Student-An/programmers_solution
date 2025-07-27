import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            count ++;
        }

        System.out.println(count);
    }
}