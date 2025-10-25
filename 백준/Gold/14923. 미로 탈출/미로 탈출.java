import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};
    static int[][] arr;
    static int[][][] result;
    static Info start, end;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = new Info(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        st = new StringTokenizer(br.readLine());
        end = new Info(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[2][n][m];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        bfs();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            min = Math.min(result[i][end.r][end.c], min);
        }

        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
    }

    static void bfs() {
        result[0][start.r][start.c] = 0;
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        queue.add(new Info(start.r, start.c, 0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    // 벽 부수지 x
                    if(arr[nr][nc] == 0 && result[now.wall][nr][nc] > now.count + 1) {
                        result[now.wall][nr][nc] = now.count + 1;
                        queue.add(new Info(nr, nc, result[now.wall][nr][nc], now.wall));
                    }

                    // 벽을 부순적이 없다면 부수기
                    if(arr[nr][nc] == 1 && now.wall == 0 && result[1][nr][nc] > now.count + 1) {
                        result[1][nr][nc] = now.count + 1;
                        queue.add(new Info(nr, nc, result[1][nr][nc], 1));
                    }
                }
            }
        }
    }

    static class Info {
        int r, c, count, wall;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Info(int r, int c, int count, int wall) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.wall = wall;
        }
    }
}