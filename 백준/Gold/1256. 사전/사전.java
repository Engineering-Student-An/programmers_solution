import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long k = scanner.nextLong();
        
        long[][] arr = new long[n+m+1][n+m+1];

        for (int i = 0; i <= n+m; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i <= n+m; i++) {
            for (int j = 1; j <= n+m; j++) {
                if(arr[i-1][j-1] + arr[i-1][j] > 1000000000) {
                    arr[i][j] = 1000000001;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }

        if(k <= arr[n+m][n]) {
            StringBuilder sb = new StringBuilder();
            int a = n;
            for (int i = 1; i <= n + m; i++) {
                // a 선택 가능한지
                if (a > 0 && arr[n + m - i][a - 1] >= k) {
                    sb.append("a");
                    a--;
                }
                // a 선택 불가능한지
                else {
                    sb.append("z");
                    if (a > 0) k -= arr[n + m - i][a - 1];
                }
            }

            System.out.print(sb);
        } else {
            System.out.println(-1);
        }
    }
}