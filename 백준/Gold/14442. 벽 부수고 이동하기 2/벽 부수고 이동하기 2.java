import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[][] arr;
    static int[][][] result;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        result = new int[k+1][n][m];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    result[i][j][l] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i <= k; i++) {
            result[i][0][0] = 1;
        }

        bfs();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            min = Math.min(min, result[i][n - 1][m - 1]);
        }

        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
    }

    static void bfs() {

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.distance, o2.distance));
        queue.add(new Info(0, 0, 0, 1));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    // 벽을 안 뚫을 때
                    if(arr[nr][nc] == 0 && result[now.count][nr][nc] > now.distance + 1) {
                        result[now.count][nr][nc] = now.distance + 1;
                        queue.add(new Info(nr, nc, now.count, result[now.count][nr][nc]));
                    }
                    // 벽을 뚫을 때
                    else if (arr[nr][nc] == 1 && now.count < k && result[now.count + 1][nr][nc] > now.distance + 1) {
                        result[now.count + 1][nr][nc] = now.distance + 1;
                        queue.add(new Info(nr, nc, now.count + 1, result[now.count + 1][nr][nc]));
                    }
                }
            }
        }
    }

    static class Info {
        int r, c, count, distance;

        public Info(int r, int c, int count, int distance) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.distance = distance;
        }
    }
}