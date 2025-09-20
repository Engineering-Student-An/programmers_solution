import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[][][] arr = new int[m+1][n+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    arr[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        arr[0][left][right] = 0;
        for (int k = 1; k <= m; k++) {
            int num = Integer.parseInt(br.readLine());

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(arr[k-1][i][j] != Integer.MAX_VALUE) {
                        if(num < i) arr[k][num][j] = Math.min(arr[k][num][j], arr[k - 1][i][j] + Math.abs(num - i));
                        else if(num > j) arr[k][i][num] = Math.min(arr[k][i][num], arr[k - 1][i][j] + Math.abs(num - j));
                        else {
                            arr[k][num][j] = Math.min(arr[k][num][j], arr[k - 1][i][j] + Math.abs(num - i));
                            arr[k][i][num] = Math.min(arr[k][i][num], arr[k - 1][i][j] + Math.abs(num - j));
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                min = Math.min(arr[m][i][j], min);
            }
        }

        System.out.println(min);
    }
}