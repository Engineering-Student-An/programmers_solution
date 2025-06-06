import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        result = new int[n][m];
        int startRow= 0 , startCol = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(startRow, startCol);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(result[i][j] == Integer.MAX_VALUE) {
                    sb.append(arr[i][j] == 0 ? 0 : -1).append(" ");
                } else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int i, int j) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(i, j));

        result[i][j] = 0;
        int[] dirRow = {0, 1, 0, -1};
        int[] dirCol = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextRow = now.row + dirRow[k];
                int nextCol = now.col + dirCol[k];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && result[nextRow][nextCol] == Integer.MAX_VALUE && arr[nextRow][nextCol] == 1) {
                    result[nextRow][nextCol] = result[now.row][now.col] + 1;
                    queue.add(new Info(nextRow, nextCol));
                }
            }
        }
    }

    static class Info {
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}