import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        final long INF = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i!=j) arr[i][j] = INF;
            }
        }


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[start][end] = Math.min(value, arr[start][end]);
        }

        for (int k = 1; k <= n; k++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    arr[start][end] = Math.min(arr[start][end], arr[start][k] + arr[k][end]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((arr[i][j] != INF) ? arr[i][j] : "0");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}