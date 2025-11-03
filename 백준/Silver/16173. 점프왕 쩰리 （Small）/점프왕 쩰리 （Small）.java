import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs() ? "HaruHaru" : "Hing");
    }
    static boolean bfs() {

        int[] dirRow = {0, 1}, dirCol = {1, 0};

        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int nr = now.r + dirRow[i] * arr[now.r][now.c];
                int nc = now.c + dirCol[i] * arr[now.r][now.c];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visit[nr][nc]) {

                    if (nr == n - 1 && nc == n - 1) {
                        return true;
                    }
                    visit[nr][nc] = true;
                    queue.add(new Info(nr, nc));
                }
            }
        }

        return false;
    }
    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}