import java.util.Scanner;

public class Main {

    static String line;
    static int[] must;
    static int[] part;
    static int result = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();

        line = scanner.next();

        must = new int[4];
        for (int i = 0; i < 4; i++) {
            must[i] = scanner.nextInt();
        }

        part = new int[4];
        for (int i = 0; i < p; i++) {
            part[check(i)] ++;
        }

        count();

        int left = 0;
        int right = p-1;
        while(right < n-1) {

            part[check(left)] --;
            left ++;
            right ++;
            part[check(right)] ++;

            count();
        }

        System.out.println(result);
    }

    static int check(int i) {
        char ch = line.charAt(i);

        if(ch == 'A') {
            return 0;
        } else if(ch == 'C') {
            return 1;
        } else if(ch == 'G') {
            return 2;
        } else {
            return 3;
        }
    }

    static void count() {
        for (int i = 0; i < 4; i++) {
            if(part[i] < must[i]) return;
        }

        result ++;
    }
}