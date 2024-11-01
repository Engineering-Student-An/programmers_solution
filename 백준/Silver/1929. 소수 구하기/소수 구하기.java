import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean[] isPrime = new boolean[m+1];

        for (int i = 2; i <= m; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= m; i++) {
            if(isPrime[i]) {
                for (int j = i*2; j <= m; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if(isPrime[i]) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }
}