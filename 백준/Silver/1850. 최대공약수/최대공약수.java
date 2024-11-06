import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();

        StringBuilder sb = new StringBuilder();
        long gcd = gcd(a,b);

        for (int i = 0; i < gcd; i++) {
            sb.append(1);
        }


        System.out.print(sb);
    }

    private static long gcd(long a, long b) {

        long max = Math.max(a, b);
        long min = Math.min(a, b);

        while(true) {
            long mod = max % min;

            if(mod == 0) break;

            max = min;
            min = mod;
        }

        return min;
    }
}