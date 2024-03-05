import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int m = arr[i];
            int start = 0;
            int end = n-1;

            while(start < end) {
                int now = arr[start] + arr[end];
                if(now == m) {
                    if(start != i && end != i) {
                        ans ++;
                        break;
                    } else if(start == i) {
                        start ++;
                    } else {
                        end --;
                    }

                } else if(now > m) {
                    end --;
                } else {
                    start ++;
                }
            }
        }
        System.out.println(ans);
    }
}