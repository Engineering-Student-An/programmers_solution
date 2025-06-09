import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] arr = new long[n+1];
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + 1;

            if(i % 2 == 0) arr[i] = Math.min(arr[i], arr[i/2] + 1);
            if(i % 3 == 0) arr[i] = Math.min(arr[i], arr[i/3] + 1);
        }

        System.out.println(arr[n]);

        StringBuilder sb = new StringBuilder();
        int index = n;
        while(index > 0) {
            sb.append(index).append(" ");
            if(index % 3 == 0 && arr[index / 3] == arr[index] - 1)  index /= 3;
            else if(index  % 2 == 0 && arr[index / 2] == arr[index] - 1) index /= 2;
            else index --;
        }
        System.out.println(sb);
    }
}