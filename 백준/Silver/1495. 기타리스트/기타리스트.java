import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] result = new boolean[n + 1][m + 1];
        result[0][s] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(result[i-1][j]) {
                    if(j + arr[i-1] >= 0 && j + arr[i-1] <= m) result[i][j + arr[i-1]] = true;
                    if(j - arr[i-1] >= 0 && j - arr[i-1] <= m) result[i][j - arr[i-1]] = true;
                }
            }
        }

        int index = -1;
        for (int i = m; i >= 0; i--) {
            if(result[n][i]) {
                index = i;
                break;
            }
        }

        System.out.println(index);
    }
}