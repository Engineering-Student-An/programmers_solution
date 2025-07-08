import java.util.Scanner;

public class Main {

    static final long mod = 1000000007;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long[][] result = fibo(n);

        System.out.println(result[0][1] % mod);
    }

    static long[][] fibo(long n) {

        if(n == 0) return new long[][]{{0, 0}, {0, 0}};
        else if(n == 1) return new long[][]{{1, 1}, {1, 0}};

        long[][] half = fibo(n/2);
        if(n % 2 == 0) return multiply(half, half);
        else return multiply(multiply(half, half), new long[][]{{1, 1}, {1, 0}});
    }

    static long[][] multiply(long[][] one, long[][] two) {

        long[][] result = new long[2][2];
        result[0][0] = ((one[0][0] * two[0][0]) % mod + (one[0][1] * two[0][1]) % mod) % mod;
        result[0][1] = ((one[0][0] * two[0][1]) % mod + (one[0][1] * two[1][1]) % mod) % mod;
        result[1][0] = ((one[1][0] * two[0][0]) % mod + (one[1][1] * two[0][1]) % mod) % mod;
        result[1][1] = ((one[1][0] * two[0][1]) % mod + (one[1][1] * two[1][1]) % mod) % mod;

        return result;
    }
}