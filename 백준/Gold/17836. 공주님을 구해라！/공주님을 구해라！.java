import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, t;
    static int[][] arr, result;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println((result[n-1][m-1] <= t) ? result[n-1][m-1] : "Fail");
    }

    static void bfs() {

        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        result[0][0] = 0;

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        queue.add(new Info(0, 0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && result[nr][nc] > now.count + 1 && arr[nr][nc] != 1) {
                    result[nr][nc] = now.count + 1;
                    if(arr[nr][nc] == 2) {
                        result[n-1][m-1] = Math.min(result[n-1][m-1], result[nr][nc] + (n-1-nr) + (m-1-nc));
                        continue;
                    }

                    queue.add(new Info(nr, nc, result[nr][nc]));
                }
            }
        }
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