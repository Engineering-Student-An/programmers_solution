import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k;
    static boolean[][] visit;
    static List<Integer> areas;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    visit[j][l] = true;
                }
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j]) queue.add(dfs(i, j));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(queue.size()).append("\n");
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb);
    }

    static int dfs(int i, int j) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(i, j));

        visit[i][j] = true;
        int area = 0;

        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            area ++;
            for (int l = 0; l < 4; l++) {
                int nextRow = poll.row + dirRow[l];
                int nextCol = poll.col + dirCol[l];

                if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && !visit[nextRow][nextCol]) {
                    visit[nextRow][nextCol] = true;
                    queue.add(new Info(nextRow, nextCol));
                }
            }
        }

        return area;
    }

    static class Info {
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}