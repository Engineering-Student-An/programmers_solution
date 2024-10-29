import java.util.Scanner;

public class Main {

    static StringBuilder sb;
    static int n;
    static int[] nextNum = {1,3,5,7,9};
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        sb = new StringBuilder();
        int[] first = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            int cnt = 1;
            nextCheck(first[i], cnt);
        }

        System.out.print(sb);
    }

    private static void nextCheck(int num, int cnt) {
        if(!isPrime(num)) return;

        if(cnt == n) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 0; i < 5; i++) {
            String n = String.valueOf(num) + String.valueOf(nextNum[i]);
            nextCheck(Integer.parseInt(n), cnt+1);
        }
    }

    private static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        if(sqrt*sqrt == num) {
            return false;
        }

        for (int i = 2; i <= sqrt; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}