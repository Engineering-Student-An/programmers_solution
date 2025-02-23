import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] arr = new long[n+1];

        if(n>1) arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = ((i-1) * (arr[i-1] % 1000000000 + arr[i-2] % 1000000000))%1000000000;
        }

        System.out.println(arr[n]);
    }
}