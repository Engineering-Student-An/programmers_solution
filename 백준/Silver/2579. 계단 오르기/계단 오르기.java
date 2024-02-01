import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] ans = new int [n+1];
        ans[1] = arr[1];
        if(n>=2) ans[2] = arr[1] + arr[2];
        for (int i = 3; i <= n; i++) {
            ans[i] = Math.max(ans[i-3] + arr[i-1], ans[i-2]) + arr[i];
        }
        System.out.println(ans[n]);
    }
}
