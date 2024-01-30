import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                arr[i] = Math.min(arr[i/2], arr[i/3]) + 1;
            } else if (i % 2 == 0) {
                arr[i] = Math.min(arr[i-1], arr[i/2]) + 1;
            } else if (i % 3 == 0) {
                arr[i] = Math.min(arr[i-1], arr[i/3]) + 1;
            } else {
                arr[i] = arr[i-1] + 1;
            }
        }
        System.out.println(arr[n]);
    }
}
