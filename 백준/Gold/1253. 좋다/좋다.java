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
        int result = 0;

        for (int i = 0; i < n; i ++) {
            int start_idx = 0;
            int end_idx = n-1;
            while(start_idx < end_idx) {
                int sum = arr[start_idx] + arr[end_idx];
                if (sum == arr[i]) {
                    if(start_idx != i && end_idx != i) {
                        result ++;
                        break;
                    }
                    else if(start_idx == i) {
                        start_idx ++;
                    } else {
                        end_idx --;
                    }

                } else if(sum > arr[i]) {
                    end_idx --;
                } else {
                    start_idx ++;
                }
            }
        }

        System.out.println(result);
    }
}