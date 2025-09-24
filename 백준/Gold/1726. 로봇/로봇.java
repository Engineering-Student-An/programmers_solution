import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][][] result;
    static int[] dirRow = {0, 0, 1, -1}, dirCol = {1, -1, 0, 0};
    static Info start, end;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1);

        st = new StringTokenizer(br.readLine());
        end = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1);


        result = new int[4][n+1][m+1];
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    result[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {

        result[start.dir][start.r][start.c] = 0;
        Queue<Info> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            // 회전
            int left = 0, right = 0;
            if(now.dir == 0 || now.dir == 1) {
                left = 3;
                right = 2;
            } else {
                right = 1;
            }

            if(result[left][now.r][now.c] > result[now.dir][now.r][now.c] + 1) {
                result[left][now.r][now.c] = result[now.dir][now.r][now.c] + 1;
                queue.add(new Info(now.r, now.c, left));
            }

            if(result[right][now.r][now.c] > result[now.dir][now.r][now.c] + 1) {
                result[right][now.r][now.c] = result[now.dir][now.r][now.c] + 1;
                queue.add(new Info(now.r, now.c, right));
            }

            // 이동
            for (int k = 1; k <= 3; k++) {
                int nr = now.r + (dirRow[now.dir] * k);
                int nc = now.c + (dirCol[now.dir] * k);

                if(nr >= 1 && nc >= 1 && nr <= n && nc <= m && result[now.dir][nr][nc] > result[now.dir][now.r][now.c] + 1 && arr[nr][nc] == 0) {
                    result[now.dir][nr][nc] = result[now.dir][now.r][now.c] + 1;
                    queue.add(new Info(nr, nc, now.dir));
                }

                if(nr >= 1 && nc >= 1 && nr <= n && nc <= m && arr[nr][nc] == 1) break;
            }

            if(result[end.dir][end.r][end.c] != Integer.MAX_VALUE) return result[end.dir][end.r][end.c];
        }

        return result[end.dir][end.r][end.c];
    }

    static class Info {
        int r, c, dir;

        public Info(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}