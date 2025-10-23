import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] result = new int[n + 1][k + 1];
        result[1][1] = arr[1];
        int ans = (k == 1) ? result[1][1] : Integer.MIN_VALUE;
        for (int i = 2; i < n + 1; i++) {
            result[i][1] = Math.max(result[i - 1][1] + arr[i], arr[i]);
            if(k == 1) ans = Math.max(ans, result[i][1]);
        }

        for (int j = 2; j < k + 1; j++) {
            result[j * 2 - 2][j] = Integer.MIN_VALUE;
            for (int i = j * 2 - 1; i < n + 1; i++) {
                int max = Integer.MIN_VALUE;
                for (int l = i - 2; l >= (j - 1) * 2 - 1 ; l--) {
                    max = Math.max(max, result[l][j - 1]);
                }

                result[i][j] = Math.max(max, result[i - 1][j]) + arr[i];
                if(j == k) ans = Math.max(ans, result[i][j]);
            }
        }
//
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < k + 1; j++) {
//                System.out.print(result[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        System.out.println(ans);
    }
}