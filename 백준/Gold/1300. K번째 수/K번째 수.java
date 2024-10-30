import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int k = scanner.nextInt();

        int start = 1;
        int end = k;
        int ans = -1;
        while(start <= end) {

            int middle = (start + end) / 2;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(n, middle/i);
            }

            if(count >= k) {
                end = middle - 1;
                ans = middle;
            } else {
                start = middle + 1;
            }
        }

        System.out.println(ans);
    }
}