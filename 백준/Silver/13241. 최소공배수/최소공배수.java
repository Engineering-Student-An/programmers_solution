import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long a1 = scanner.nextLong();
        long b1 = scanner.nextLong();

        long a = a1;
        long b = b1;

        if(b > a) {
            long temp = a;
            a = b;
            b = temp;
        }


        do {
            long mod = a % b;

            a = b;
            b = mod;

        } while (b != 0);

        System.out.println(a * (a1 / a) * (b1 / a));
    }
}