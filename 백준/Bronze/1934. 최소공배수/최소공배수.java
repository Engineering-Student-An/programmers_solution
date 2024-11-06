import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int gcd = gcd(a,b);

            long result = (long) a * b / gcd;
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    private static int gcd(int a, int b) {

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while(true) {
            int mod = max % min;

            if(mod == 0) break;

            max = min;
            min = mod;
        }

        return min;
    }
}