import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i+1] - arr[i];
        }
        diff[n-1] = 1;

        int ans = 4;
        boolean chk = false;
        for (int i = 5; i > 1; i--) {
            for (int j = 0; j <= n - i; j++) {
                int sum = 0;
                for (int k = j; k < j+i-1; k++) {
                    sum += diff[k]-1;
                }
                if(sum <= 5-i && ans > 5-i) {
                    ans = 5-i;
                    chk = true;
                    break;
                }
            }
            if(chk) break;
        }
        System.out.println(ans);
    }
}