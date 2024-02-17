import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();

        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] sum = new int [n+1];
        sum[0] = 0;

        for (int i = 1; i <= n; i++) {
            sum[i] = arr[i] + sum[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            sb.append(sum[end] - sum[start-1]);
            sb.append("\n");
        }

        System.out.print(sb);
    }

}

