import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static Info[] cctv;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        int cctvCount = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] >= 1 && arr[i][j] <= 5) cctvCount ++;
            }
        }

        cctv = new Info[cctvCount];
        cctvCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] >= 1 && arr[i][j] <= 5) {
                    cctv[cctvCount ++] = new Info(i, j, arr[i][j], 0);
                }
            }
        }

        direction(0);

        System.out.println(result);
    }

    static void direction(int i) {
        if(i == cctv.length) {
            checkSagak();
            return;
        }

        // 기준 방향 0개 탐색
        if(cctv[i].type == 5) {
            direction(i + 1);
        }

        // 기준 방향 2개만 탐색
        else if(cctv[i].type == 2) {
            for (int j = 0; j < 2; j++) {
                cctv[i].dir = j;
                direction(i + 1);
            }
        }

        // 기준 방향 4개 모두 탐색
        else {
            for (int j = 0; j < 4; j++) {
                cctv[i].dir = j;
                direction(i + 1);
            }
        }
    }

    static void checkSagak() {
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < cctv.length; i++) {
            int dir = cctv[i].dir;

            cctvLine(cctv[i].r, cctv[i].c, dir, visit);

            if(cctv[i].type == 2) {
                cctvLine(cctv[i].r, cctv[i].c, (dir + 2) % 4, visit);
            } else if(cctv[i].type == 3) {
                cctvLine(cctv[i].r, cctv[i].c, (dir + 1) % 4, visit);
            } else if(cctv[i].type == 4) {
                for (int j = 1; j <= 2; j++) {
                    cctvLine(cctv[i].r, cctv[i].c, (dir + j) % 4, visit);
                }
            } else if(cctv[i].type == 5) {
                for (int j = 1; j <= 3; j++) {
                    cctvLine(cctv[i].r, cctv[i].c, (dir + j) % 4, visit);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0 && !visit[i][j]) count ++;
            }
        }
        
        result = Math.min(result, count);
    }

    static void cctvLine(int r, int c, int dir, boolean[][] visit) {
        while (r >= 0 && c >= 0 && r < n && c < m && arr[r][c] != 6) {
            visit[r][c] = true;

            r += dirRow[dir];
            c += dirCol[dir];
        }
    }

    static class Info {
        int r, c, type, dir;

        public Info(int r, int c, int type, int dir) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.dir = dir;
        }
    }
}