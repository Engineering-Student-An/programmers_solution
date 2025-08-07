import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] result = new int[h + 1][3][m + 1];
        int[] arr = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 0번 옮기기 먼저 저장
        for (int i = 1; i <= m; i++) {
            result[0][1][i] = (arr[i] == 1) ? result[0][1][i-1] + 1 : result[0][1][i-1];
        }
        int max = result[0][1][m];

        // 1 ~ h번 옮기기 저장
        for (int k = 1; k <= h; k++) {
            int r = (k % 2 == 0) ? 1 : 2;

            for (int i = k; i <= m; i++) {
                if(r == 1) result[k][r][i] = Math.max(result[k - 1][2][i - 1], result[k][r][i - 1]);
                else result[k][r][i] = Math.max(result[k - 1][1][i - 1], result[k][r][i - 1]);

                if(arr[i] == r) result[k][r][i] ++;
            }

            max = Math.max(max, result[k][r][m]);
        }

        System.out.println(max);
    }
}