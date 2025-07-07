import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a1 = scanner.nextInt();
        int a0 = scanner.nextInt();
        int c = scanner.nextInt();
        int n0 = scanner.nextInt();

        if(a1 == c) {
            System.out.println((a0 <= 0) ? 1 : 0);
        } else if(a1 > c) {
            System.out.println(0);
        } else {
            double n = (double) a0 / (c-a1);

            if(n0 >= n) System.out.println(1);
            else System.out.println(0);
        }
    }
}