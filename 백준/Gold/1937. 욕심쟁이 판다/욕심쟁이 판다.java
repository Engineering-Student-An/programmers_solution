import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr, result;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[n][n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(result[i][j] == 0) dfs(i, j);
                max = Math.max(max, result[i][j]);
            }
        }
        System.out.println(max);
    }

    static void dfs(int r, int c) {
        boolean fin = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = r + dirRow[i];
            int nextCol = c + dirCol[i];

            if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n && arr[r][c] < arr[nextRow][nextCol]) {
                if(result[nextRow][nextCol] == 0) {
                    dfs(nextRow, nextCol);
                }

                result[r][c] = Math.max(result[r][c], result[nextRow][nextCol] + 1);

                fin = false;
            }
        }

        if(fin) {
            result[r][c] = 1;
        }
    }
}