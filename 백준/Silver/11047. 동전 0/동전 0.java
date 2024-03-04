import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = n-1; i >= 0 ; i--) {
            arr[i] = scanner.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(k == 0) break;
            if(arr[i] <= k) {
                ans += k/arr[i];
                k %= arr[i];
            }

        }

        System.out.println(ans);

    }
}