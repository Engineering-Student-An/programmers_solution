import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                if(line.charAt(j) == '-') arr[i][j] = 1;
                else arr[i][j] = 2;
            }
        }

        boolean[][] check = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean nowCheck = false;
                if(arr[i][j] == 1){
                    for (int k = 0; k < m - j; k++) {
                        if(arr[i][j+k]==1 && !check[i][j+k]) {
                            check[i][j+k] = true;
                            nowCheck = true;
                        }
                        else break;
                    }
                    if(nowCheck) ans++;
                } else if(arr[i][j]==2){
                    for (int k = 0; k < n - i; k++) {
                        if(arr[i+k][j]==2 && !check[i+k][j]) {
                            check[i+k][j] = true;
                            nowCheck = true;
                        }
                        else break;
                    }
                    if(nowCheck) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}