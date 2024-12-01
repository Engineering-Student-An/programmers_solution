import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[5001];

        arr[3] = 1;
        arr[5] = 1;
        for (int i = 6; i <= n; i++) {

            if(arr[i-3] == 0 && arr[i-5] == 0) arr[i] = 0;
            else {
                if(arr[i-3] == 0) {
                    arr[i] = arr[i-5] + 1;
                } else if(arr[i-5] == 0) {
                    arr[i] = arr[i-3] + 1;
                } else {
                    arr[i] = Math.min(arr[i-3], arr[i-5]) + 1;
                }
            }
        }

        System.out.println(arr[n] == 0 ? -1 : arr[n]);
    }
}