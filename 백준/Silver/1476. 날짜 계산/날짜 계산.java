import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        a = (a==15) ? 0 : a;
        b = (b==28) ? 0 : b;
        c = (c==19) ? 0 : c;

        int ans = 1;
        while (true) {
            if(ans % 15 == a && ans % 28 == b && ans % 19 == c) {
                System.out.println(ans);
                break;
            }
            ans ++;
        }
    }
}