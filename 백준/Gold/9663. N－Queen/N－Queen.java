import java.util.Scanner;

public class Main {

    static int[] arr;
    static long result = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[0] = i;
            find(n, 1);
        }

        System.out.println(result);
    }

    static void find(int n, int count) {

        if(count == n) {
            result ++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean isOk = true;
            for (int j = 0; j < count; j++) {
                if(arr[j] == i || j - arr[j] == count - i || j + arr[j] == i + count) {
                    isOk = false;
                    break;
                }
            }

            if(isOk) {
                arr[count] = i;
                find(n, count+1);
            }
        }
    }
}