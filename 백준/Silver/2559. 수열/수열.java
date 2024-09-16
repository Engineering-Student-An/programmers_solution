import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int max = sum;
        int start_idx = 0;
        int end_idx = k-1;

        while (end_idx < n-1) {
            sum -= arr[start_idx ++];
            sum += arr[++end_idx];

            if(sum > max) max = sum;
        }

        System.out.println(max);
    }
}