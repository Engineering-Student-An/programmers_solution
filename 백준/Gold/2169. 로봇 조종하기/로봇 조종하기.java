import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[n+1][m+1];
        result[1][1] = arr[1][1];
        for (int i = 2; i <= m; i++) result[1][i] = result[1][i-1] + arr[1][i];

        for (int i = 2; i <= n; i++) {
            int[] toRight = new int[m+1];
            int[] toLeft = new int[m+1];

            toRight[1] = result[i-1][1] + arr[i][1];
            for (int j = 2; j <= m; j++) {
                toRight[j] = Math.max(toRight[j-1], result[i-1][j]) + arr[i][j];
            }

            toLeft[m] = result[i-1][m] + arr[i][m];
            for (int j = m-1; j >= 1; j--) {
                toLeft[j] = Math.max(toLeft[j+1], result[i-1][j]) + arr[i][j];
            }


            for (int j = 1; j <= m; j++) {
                result[i][j] = Math.max(toRight[j], toLeft[j]);
            }
        }

        System.out.println(result[n][m]);
    }
}