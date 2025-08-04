import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, l;
    static int[][][] arr;
    static int[] dirH = {1, -1, 0, 0, 0, 0};
    static int[] dirR = {0, 0, 0, 1, 0, -1};
    static int[] dirC = {0, 0, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(l == 0 && n == 0 && m == 0) break;

            Info start = null, end = null;

            arr = new int[l][n][m];
            for (int k = 0; k < l; k++) {
                for (int i = 0; i < n; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < m; j++) {
                        char c = line.charAt(j);
                        if(c == '#') arr[k][i][j] = 1;
                        else arr[k][i][j] = 0;

                        if(c == 'S') start = new Info(k, i, j, 0);
                        else if(c == 'E') end = new Info(k, i, j, 0);
                    }
                }
                br.readLine();
            }

            int result = bfs(start, end);
            sb.append((result == Integer.MAX_VALUE) ? "Trapped!" : "Escaped in " + result + " minute(s).").append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(Info start, Info end) {

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        queue.add(start);
        boolean[][][] visit = new boolean[l][n][m];
        visit[start.h][start.r][start.c] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nh = now.h + dirH[i];
                int nr = now.r + dirR[i];
                int nc = now.c + dirC[i];

                if (nh >= 0 && nh < l && nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nh][nr][nc] == 0 && !visit[nh][nr][nc]) {
                    if(nh == end.h && nr == end.r && nc == end.c) return now.count + 1;
                    queue.add(new Info(nh, nr, nc, now.count + 1));
                    visit[nh][nr][nc] = true;
                }
            }
        }


        return Integer.MAX_VALUE;
    }

    static class Info {
        int h, r, c, count;

        public Info(int h, int r, int c, int count) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}