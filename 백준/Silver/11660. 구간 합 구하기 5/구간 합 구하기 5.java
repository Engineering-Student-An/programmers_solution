import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();

        int[][] arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] sum = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] + arr[i][j] - sum[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int s_i = scanner.nextInt();
            int s_j = scanner.nextInt();
            int e_i = scanner.nextInt();
            int e_j = scanner.nextInt();
            int s = sum[e_i][e_j] - sum[s_i - 1][e_j] - sum[e_i][s_j - 1] + sum[s_i - 1][s_j - 1];
            sb.append(s);
            sb.append("\n");
        }

        System.out.print(sb);



    }

}

