import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();

        int next = a%b;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            next *= 10;
            answer = next / b;
            next = next % b;
        }

        System.out.println(answer);
    }
}