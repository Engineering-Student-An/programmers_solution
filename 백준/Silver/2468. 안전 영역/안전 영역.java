import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] nextRow = {0, 1, 0, -1};
    static final int[] nextCol = {1, 0, -1, 0};
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i][j], max);
            }
        }

        int result = 1;

        for (int t = 1; t <= max; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] --;
                }
            }

            boolean[][] visit = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] > 0 && !visit[i][j]) {
                        count ++;
                        bfs(i, j, visit);
                    }
                }
            }
            result = Math.max(result, count);
            if(count == 0) break;
        }

        System.out.println(result);
    }

    static void bfs(int i, int j, boolean[][] visit) {

        visit[i][j] = true;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(i, j));

        while (!queue.isEmpty()) {
            Info poll = queue.poll();

            int row = poll.row;
            int col = poll.col;

            for (int k = 0; k < 4; k++) {
                int nRow = row + nextRow[k];
                int nCol = col + nextCol[k];

                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < n && !visit[nRow][nCol] && arr[nRow][nCol] > 0) {
                    queue.add(new Info(nRow, nCol));
                    visit[nRow][nCol] = true;
                }
            }
        }
    }

    static class Info {
        int row;
        int col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}