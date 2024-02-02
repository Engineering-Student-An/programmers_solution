import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        Long[] arr = new Long[101];
        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        for (int i = 3; i < 101; i++) {
            arr[i] = arr[i-3] + arr[i-2];
        }

        for (int tt = 0; tt < t; tt++) {
            int n = scanner.nextInt();
            System.out.println(arr[n]);
        }
    }
}