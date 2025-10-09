import java.util.*;

public class Main {

    public static long countFactor(long n, int p) {
        long count = 0;
        while (n >= p) {
            count += n / p;
            n /= p;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        long two = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);
        long five = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);

        System.out.println(Math.min(two, five));
    }
}
