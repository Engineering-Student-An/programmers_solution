import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];

        Info first = null;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if(c != '#') arr[i][j] = true;
                if(c == 'o') {
                    if(first == null) first = new Info(i, j, 0, 0, 0);
                    else {
                        first.r2 = i;
                        first.c2 = j;
                    }
                }
            }
        }

        System.out.println(bfs(first));
    }

    static int bfs(Info first) {

        Queue<Info> queue = new LinkedList<>();
        queue.add(first);

        int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            if(now.count >= 10) break;

            for (int i = 0; i < 4; i++) {
                int nr1 = now.r1 + dirRow[i];
                int nc1 = now.c1 + dirCol[i];
                int nr2 = now.r2 + dirRow[i];
                int nc2 = now.c2 + dirCol[i];

                int out = checkOut(nr1, nc1, nr2, nc2);

                if(out == 2) continue;
                else if(out == 1) return now.count + 1;

                nr1 = (!arr[nr1][nc1]) ? now.r1 : nr1;
                nc1 = (!arr[nr1][nc1]) ? now.c1 : nc1;
                nr2 = (!arr[nr2][nc2]) ? now.r2 : nr2;
                nc2 = (!arr[nr2][nc2]) ? now.c2 : nc2;

                if(nr1 == now.r1 && nc1 == now.c1 && nr2 == now.r2 && nc2 == now.c2) continue;
                queue.add(new Info(nr1, nc1, nr2, nc2, now.count + 1));
            }
        }

        return -1;
    }

    static int checkOut(int r1, int c1, int r2, int c2) {
        int count = 0;
        if(r1 < 0 || r1 >= n || c1 < 0 || c1 >= m) count ++;
        if(r2 < 0 || r2 >= n || c2 < 0 || c2 >= m) count ++;

        return count;
    }

    static class Info {
        int r1, c1, r2, c2, count;

        public Info(int r1, int c1, int r2, int c2, int count) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.count = count;
        }
    }
}