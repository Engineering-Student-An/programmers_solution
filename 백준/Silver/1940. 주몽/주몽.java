import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int small = 0;
        int large = n-1;
        int ans = 0;
        while(small < large) {
            int now = arr[small] + arr[large];
            if(now == m) {
                small ++;
                large --;
                ans++;
            } else if(now > m) {
                large --;
            } else {
                small ++;
            }
        }
        System.out.println(ans);
    }
}