import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int x = scanner.nextInt();

        m += x;
        n += m/60;
        m %= 60;
        n %= 24;

        System.out.println(n + " " + m);
    }
}

