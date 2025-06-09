import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static long[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new long[n][m];
        result[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            result[i][0] = result[i-1][0] + arr[i][0];
        }
        for (int i = 1; i < m; i++) {
            result[0][i] = result[0][i-1] + arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                result[i][j] = Math.max(Math.max(result[i-1][j], result[i][j-1]), result[i-1][j-1]) + arr[i][j];
            }
        }
        
        System.out.println(result[n-1][m-1]);
    }
}
