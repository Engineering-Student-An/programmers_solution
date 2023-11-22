import java.util.Scanner;

public class Main {

    public static class zeroOne{
        int zero;
        int one;

        public zeroOne(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
//        int[] arr = new int[1000];
        zeroOne[][] fibo = new zeroOne[1000][41];
        for (int i = 0; i < t; i++) {
            fibo[i][0] = new zeroOne(1, 0);
            fibo[i][1] = new zeroOne(0, 1);
            int n = scanner.nextInt();
            for (int j = 2; j <= n; j++) {
                fibo[i][j] = new zeroOne(fibo[i][j - 2].zero + fibo[i][j - 1].zero
                        , fibo[i][j - 2].one + fibo[i][j - 1].one);
            }
            System.out.println(fibo[i][n].zero + " " + fibo[i][n].one);
        }
    }
}
