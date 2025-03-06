import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] positive = new long[1000001];
        positive[0] = 0;
        positive[1] = 1;

        for (int i = 2; i <= 1000000; i++) {
            positive[i] = ((positive[i-2] % 1000000000) + (positive[i-1] % 1000000000)) % 1000000000;
        }

        long[] negative = new long[1000002];
        negative[1000000] = 0;
        negative[1000001] = 1;

        for (int i = 999999; i >= 0; i--) {
            negative[i] = ((negative[i+2] % 1000000000) - (negative[i+1] % 1000000000)) % 1000000000;
        }

        if(n > 0) {
            System.out.println(1);
            System.out.println(positive[n]);
        } else if(n == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            if(negative[n + 1000000] < 0) System.out.println(-1);
            else System.out.println(1);

            System.out.println(Math.abs(negative[n + 1000000]));
        }
    }
}