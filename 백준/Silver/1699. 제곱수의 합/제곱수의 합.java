import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n+1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(Math.sqrt(i) % 1 == 0.0) {
                arr[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; Math.pow(j, 2) <= i; j++) {
                    int pow = (int) Math.pow(j, 2);
                    min = Math.min(min, arr[pow] + arr[i - pow]);
                }
                arr[i] = min;
            }
        }
        System.out.println(arr[n]);
    }
}