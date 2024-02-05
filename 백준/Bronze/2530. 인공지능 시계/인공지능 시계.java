import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int d = scanner.nextInt();

        c += d;
        int sec = c%60;
        int min = c/60;
        min += b;

        int hour = min / 60;
        min %= 60;

        hour += a;
        hour %=24;

        System.out.println(hour + " " + min + " " + sec);



    }
}

