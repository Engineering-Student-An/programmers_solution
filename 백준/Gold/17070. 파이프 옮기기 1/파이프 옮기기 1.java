import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static int count = 0;

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

        visit = new boolean[n][n];
        visit[0][0] = true;
        dfs(new Info(0, 1, 1));

        System.out.println(count);
    }

    static void dfs(Info now) {

        if(now.r == n-1 && now.c == n-1) {
            count ++;
            return;
        }

        // ㅡ
        if(now.dir != 3) {
            if(now.c + 1 < n && arr[now.r][now.c + 1] == 0) dfs(new Info(now.r, now.c + 1, 1));
        }

        // \
        if(now.r + 1 < n && now.c + 1 < n && arr[now.r + 1][now.c + 1] == 0
                && arr[now.r + 1][now.c] == 0 && arr[now.r][now.c + 1] == 0) dfs(new Info(now.r + 1, now.c + 1, 2));

        // |
        if(now.dir != 1) {
            if(now.r + 1 < n && arr[now.r + 1][now.c] == 0) dfs(new Info(now.r + 1, now.c, 3));
        }
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