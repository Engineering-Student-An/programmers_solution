import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] nextRow = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] nextCol = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            int[][] arr = new int[n][m];
            boolean[][] visit = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 1 && !visit[i][j]) {
                        bfs(i,j, n, m, arr, visit);
                        count ++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int i, int j, int n, int m, int[][] arr, boolean[][] visit) {

        Queue<Info> queue = new LinkedList<>();
        visit[i][j] = true;
        queue.add(new Info(i, j));

        while (!queue.isEmpty()) {
            Info poll = queue.poll();

            for (int k = 0; k < 8; k++) {
                int ni = poll.i + nextRow[k];
                int nj = poll.j + nextCol[k];

                if(ni >= 0 && ni < n && nj >= 0 && nj < m && arr[ni][nj] == 1 && !visit[ni][nj]) {
                    visit[ni][nj] = true;
                    queue.add(new Info(ni, nj));
                }
            }
        }
    }

    static class Info {
        int i;
        int j;

        public Info(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}