import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int now = arr[i];
            int ind = i;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] < arr[j]) {
                    ind = j;
                } else break;
            }
            for (int j = i-1; j >= ind; j--) {
                arr[j+1] = arr[j];
            }
            arr[ind] = now;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (n-i) * arr[i];
        }

        System.out.println(sum);
    }
}