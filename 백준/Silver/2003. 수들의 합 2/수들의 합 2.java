import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];

        arr[0] = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            int tmp = scanner.nextInt();
            arr[i] = arr[i-1] + tmp;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == m){
                result ++;
            }
            for (int j = i+1; j < n; j++) {

                int sum = arr[j] - arr[i];
                if(sum == m) {
                    result ++;
                    break;
                }

                if(sum > m) {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}


