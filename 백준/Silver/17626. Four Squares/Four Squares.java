import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] arr = new long[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            if(Math.sqrt(i) % 1 == 0.0) arr[i] = 1;
            else{
                for (int j = 1; Math.pow(j, 2) < i; j++) {
                    arr[i] = Math.min(arr[i], arr[i - (int) Math.pow(j, 2)] + arr[(int) Math.pow(j, 2)]);
                }
            }
        }

        System.out.println(arr[n]);
    }
}