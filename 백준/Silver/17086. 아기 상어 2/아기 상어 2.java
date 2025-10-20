import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dirRow = {-1, -1, 0, 1, 1, 1, 0, -1}, dirCol = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0) result = Math.max(result, bfs(i, j));
            }
        }

        System.out.println(result);
    }

    static int bfs(int r, int c) {
        boolean[][] visit = new boolean[n][m];
        visit[r][c] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && !visit[nr][nc]) {
                    if(arr[nr][nc] == 1) return now.count + 1;

                    queue.add(new Info(nr, nc, now.count + 1));
                    visit[nr][nc] = true;
                }
            }
        }

        return 0;
    }

    static class Info {
        int r, c, count;

        public Info(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}