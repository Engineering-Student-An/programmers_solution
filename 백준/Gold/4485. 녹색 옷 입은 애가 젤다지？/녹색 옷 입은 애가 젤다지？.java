import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr, result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();

            sb.append("Problem " + (count ++) + ": ").append(result[n-1][n-1]).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs() {

        int[] dirRow = {0, 1, 0, -1};
        int[] dirCol = {1, 0, -1, 0};

        result[0][0] = arr[0][0];

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0, 0, result[0][0]));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dirRow[i];
                int nextCol = now.col + dirCol[i];

                if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n
                        && result[nextRow][nextCol] > result[now.row][now.col] + arr[nextRow][nextCol]) {
                    result[nextRow][nextCol] = result[now.row][now.col] + arr[nextRow][nextCol];
                    queue.add(new Info(nextRow, nextCol, result[nextRow][nextCol]));
                }
            }
        }
    }

    static class Info {
        int row, col, value;

        public Info(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}