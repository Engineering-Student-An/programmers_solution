import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dirRow = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dirCol = {1, 1, 0, -1, -1, -1, 0, 1};

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

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    bfs(i, j);
                    count ++;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(int r, int c) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));
        arr[r][c] = 0;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] == 1) {
                    arr[nr][nc] = 0;
                    queue.add(new Info(nr, nc));
                }
            }
        }
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}