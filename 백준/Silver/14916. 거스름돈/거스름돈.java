import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] arr = new long[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.MAX_VALUE;
        }

        if(n >= 2) arr[2] = 1;
        if(n >= 4) arr[4] = 2;
        for (int i = 5; i <= n; i++) {

            if(arr[i-2] != Long.MAX_VALUE) arr[i] = Math.min(arr[i], arr[i-2] + 1);
            if(arr[i-5] != Long.MAX_VALUE) arr[i] = Math.min(arr[i], arr[i-5] + 1);
        }

        System.out.println(arr[n] == Long.MAX_VALUE ? -1 : arr[n]);
    }
}