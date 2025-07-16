import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, sheep, wolf;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static char[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != '#' && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static void bfs(int r, int c) {
        int sh = 0, wo = 0;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));
        visit[r][c] = true;

        if(arr[r][c] == 'o') sh ++;
        else if(arr[r][c] == 'v') wo ++;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && !visit[nr][nc] && arr[nr][nc] != '#') {
                    visit[nr][nc] = true;
                    if(arr[nr][nc] == 'o') sh ++;
                    else if(arr[nr][nc] == 'v') wo ++;
                    queue.add(new Info(nr, nc));
                }
            }
        }
        if(sh > wo) sheep += sh;
        else wolf += wo;
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}