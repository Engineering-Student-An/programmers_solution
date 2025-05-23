import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[][] arr;
    static boolean[][] visit;
    static int[] dRow = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dCol = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testcase; t++) {
            n = Integer.parseInt(br.readLine());

            arr = new long[n][n];
            visit = new boolean[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());

            sb.append(bfs(startRow, startCol, endRow, endCol)).append("\n");
        }
        System.out.print(sb);
    }

    static long bfs(int startRow, int startCol, int endRow, int endCol) {

        visit[startRow][startCol] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(startRow, startCol));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            if(now.row == endRow && now.col == endCol) break;

            for (int i = 0; i < 8; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visit[nextRow][nextCol]) {
                    visit[nextRow][nextCol] = true;
                    arr[nextRow][nextCol] = arr[now.row][now.col] + 1;
                    queue.add(new Info(nextRow, nextCol));
                }
            }
        }

        return arr[endRow][endCol];
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