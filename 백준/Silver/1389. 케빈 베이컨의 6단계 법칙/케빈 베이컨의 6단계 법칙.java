import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i!=j) arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            arr[v1][v2] = 1;
            arr[v2][v1] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    arr[start][end] = Math.min(arr[start][end], arr[start][k] + arr[k][end]);
                }
            }
        }

        long min = Integer.MAX_VALUE;
        int minInd = 0;
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += arr[i][j];
            }

            if(sum < min) {
                min = sum;
                minInd = i;
            }
        }

        System.out.println(minInd);
    }
}