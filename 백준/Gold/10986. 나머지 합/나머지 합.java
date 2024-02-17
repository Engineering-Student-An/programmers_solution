import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        long[] sum = new long[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + arr[i];
        }

        long[] check = new long[m];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            sum[i] %= m;
            if(sum[i] == 0){
                ans++;
            }
            check[(int) sum[i]] ++;

        }
        for (int i = 0; i < m; i++) {
            if (check[i] > 1) {
                ans += ((check[i] * (check[i]-1)) / 2);
            }
        }
        System.out.println(ans);
    }

}

