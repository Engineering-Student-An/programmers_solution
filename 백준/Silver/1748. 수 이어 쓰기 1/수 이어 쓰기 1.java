import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] arr = new long[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = (long) (9 * Math.pow(10, i) * (i + 1));
        }

        long result = 0;
        int index = 0;
        for (int p = 8; p >= 0; p--) {
            long now = (long) Math.pow(10, p);

            if(n < now) continue;

            result += (n - now + 1) * (p+1);
            index = p - 1;
            break;
        }


        for (int i = index; i >= 0; i--) {
            result += arr[i];
        }
        System.out.println(result);
    }
}