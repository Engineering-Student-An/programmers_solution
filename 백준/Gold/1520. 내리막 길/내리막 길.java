import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr, result;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = -1;
            }
        }

        result[0][0] = 1;
        System.out.println(dfs(n-1, m-1));
    }

    static int dfs(int i, int j) {
        if(result[i][j] != -1) return result[i][j];

        result[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int nextRow = i + dirRow[k];
            int nextCol = j + dirCol[k];

            if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m
                    && arr[nextRow][nextCol] > arr[i][j]) {
                result[i][j] += dfs(nextRow, nextCol);
            }
        }

        return result[i][j];
    }
}