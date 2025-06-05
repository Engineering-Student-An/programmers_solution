import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String one = scanner.next();
        String two = scanner.next();

        int m = one.length();
        int n = two.length();
        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            if(one.charAt(0) == two.charAt(i - 1)) arr[i][1] = 1;
            else arr[i][1] = arr[i-1][1];
        }
        for (int i = 1; i <= m; i++) {
            if(two.charAt(0) == one.charAt(i - 1)) arr[1][i] = 1;
            else arr[1][i] = arr[1][i-1];
        }

        int max = -1;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if(two.charAt(i - 1) == one.charAt(j - 1)) arr[i][j] = arr[i-1][j-1] + 1;
                max = Math.max(max, arr[i][j]);
            }
        }

        System.out.println(max);
    }
}