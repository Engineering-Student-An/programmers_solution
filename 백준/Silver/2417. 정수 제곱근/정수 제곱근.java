import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        if(n == 0) System.out.println(0);
        else {
            long l = 0;
            long r = n;
            long ans = 0;
            while (l <= r) {
                long m = (l + r) / 2;

                if(Math.pow(m, 2) >= n) {
                    ans = m;
                    r = m - 1;
                } else l = m + 1;
            }

            System.out.println(ans);
        }
    }
}