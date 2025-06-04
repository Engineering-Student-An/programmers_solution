import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n % 2 != 0) System.out.println(0);
        else {
            long[] arr = new long[31];
            arr[0] = 1;
            arr[2] = 3;

            for (int i = 4; i <= n; i+=2) {
                arr[i] = arr[i-2] * arr[2];
                for (int j = 0; j <= i - 4; j+=2) {
                    arr[i] += (2 * arr[j]);
                }
            }
            System.out.println(arr[n]);
        }
    }
}