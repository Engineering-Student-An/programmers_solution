import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) { arr[i] = scanner.nextInt(); }

        int max = -2000;
        int[] ans = new int[n+1];

        for (int i = 1; i <= n; i++) {
            ans[i] = Math.max(ans[i-1] + arr[i], arr[i]);
            if(max<ans[i]) max = ans[i];
        }
        System.out.println(max);
    }
}