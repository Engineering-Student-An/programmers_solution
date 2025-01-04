import java.util.Scanner;

public class Main {

    static long c;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();
        c = scanner.nextLong();

        System.out.println(pow(a % c, b));
    }

    static long pow(long a, long b) {

        if(b == 0) {
            return 1;
        }

        long res = pow(a, b/2);
        res = (res * res) % c; // 모듈로 연산을 여기서 수행

        if (b % 2 == 1) {
            res = (res * a) % c; // 홀수인 경우에도 모듈로 연산을 수행
        }

        return res;
    }
}