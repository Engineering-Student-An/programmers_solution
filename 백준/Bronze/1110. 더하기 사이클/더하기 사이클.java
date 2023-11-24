
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int count = 0;
        int after = n;
        while (true) {
            count++;
            after = after%10*10 + (((after/10) + (after%10)) % 10);
            if(n==after) break;
        }
        System.out.println(count);
    }
}