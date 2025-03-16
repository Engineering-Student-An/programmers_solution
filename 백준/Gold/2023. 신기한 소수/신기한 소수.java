import java.util.Scanner;

public class Main {

    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[] nextPrime = {1, 3, 7, 9};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 2; i < 10; i++) {
            if(isPrime(i)) {
                dfs(i, 1);
            }
        }

        System.out.print(sb);
    }

    static void dfs(int num, int jarisu) {
        if(jarisu == n) {
            sb.append(num).append("\n");
            return;
        }

        int next = num * 10;
        for (int i = 0; i < 4; i++) {
            int nextNum = next + nextPrime[i];

            if(isPrime(nextNum)) {
                dfs(nextNum, jarisu + 1);
            }
        }

    }

    static boolean isPrime(int num) {

        if(Math.sqrt(num) == (int) Math.sqrt(num)) return false;

        for (int i = 2; i < Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}