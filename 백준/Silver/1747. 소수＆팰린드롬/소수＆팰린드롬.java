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
        if (n < 2) return false; // 2보다 작은 수는 소수가 아님
        if (n == 2) return true; // 2는 소수

        if (n % 2 == 0) return false; // 2 이외의 짝수는 소수가 아님

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) { // 홀수만 검사
            if (n % i == 0) {
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