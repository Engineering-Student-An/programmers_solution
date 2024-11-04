import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while(true) {

            if(isPalindrome(n) && isPrime(n)) {
                System.out.print(n);
                break;
            }

            n++;
        }
    }

    private static boolean isPrime(int n) {
        if(n == 1) return false;

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome(int n) {

        String num = String.valueOf(n);
        for (int i = 0; i < num.length()/2; i++) {
            if(num.charAt(i)!=num.charAt(num.length() - 1 - i)) return false;
        }

        return true;
    }
}