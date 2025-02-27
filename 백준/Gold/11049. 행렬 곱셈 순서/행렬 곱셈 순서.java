import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Matrix[] arr;
    static int[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new Matrix[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            arr[i] = new Matrix(row, col);
        }

        result = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                result[i][j] = -1;
            }
        }
        System.out.println(dp(1, n));
    }

    static int dp(int start, int end) {

        // 이미 연산한 경우
        if(result[start][end] != -1) return result[start][end];

        // 1개 연산
        if(start == end) return 0;

        // 2개 연산
        if(end - start == 1) return arr[start].row * arr[end].row * arr[end].col;

        // 3개 이상 연산
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(min, dp(start, i) + dp(i+1, end) + arr[start].row * arr[i].col * arr[end].col);
        }
        return result[start][end] = min;
    }

    static class Matrix {
        int row;
        int col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}