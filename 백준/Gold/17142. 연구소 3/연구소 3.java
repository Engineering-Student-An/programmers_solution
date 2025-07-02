import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, zero;
    static int[][] arr;
    static List<Info> virus = new ArrayList<>();
    static int[] vCheck;
    static int result = Integer.MAX_VALUE;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) virus.add(new Info(i, j));
                if(arr[i][j] == 0) zero ++;
            }
        }


        vCheck = new int[m];
        select(-1, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static int bfs() {

        boolean[][] visit = new boolean[n][n];
        int noVirus = zero;

        if(noVirus == 0) return 0;

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
        for(int i = 0; i < m; i ++) {
            Info info = virus.get(vCheck[i]);
            visit[info.r][info.c] = true;
            queue.add(info);
        }

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n && arr[nr][nc] != 1 && !visit[nr][nc]) {
                    if(arr[nr][nc] == 0) noVirus --;
                    if(noVirus == 0) return now.v + 1;

                    visit[nr][nc] = true;
                    queue.add(new Info(nr, nc, now.v + 1));
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static void select(int index, int cnt) {

        if(cnt == m) {
            result = Math.min(result, bfs());
            return;
        }
        
        for (int i = index + 1; i < virus.size(); i++) {
            vCheck[cnt] = i;
            select(i, cnt + 1);
        }
    }

    static class Info {
        int r, c, v;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Info(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
}