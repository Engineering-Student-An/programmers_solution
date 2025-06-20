import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, k, s;
    static int[][] arr;
    static Info[][] result;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        result = new Info[n][n];

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) {
                    queue.add(new Info(i, j, arr[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        x--;
        y--;

        while (!queue.isEmpty()) {
            bfs(queue.poll());
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(result[i][j].v + " ");
//            }
//            System.out.println();
//        }
        System.out.println(result[x][y] == null ? 0 : result[x][y].v);
    }

    static void bfs(Info info) {
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.t, o2.t));
        queue.add(info);
        result[info.r][info.c] = info;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(now.t >= s) continue;

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dirRow[i];
                int nextC = now.c + dirCol[i];

                if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < n) {
                    if(result[nextR][nextC] == null ||  result[nextR][nextC].t > now.t + 1) {
                        Info next = new Info(nextR, nextC, now.v, now.t + 1);

                        result[nextR][nextC] = next;
                        queue.add(next);
                    }
                }
            }
        }
    }

    static class Info {
        int r, c, v, t;

        public Info(int r, int c, int v, int t) {
            this.r = r;
            this.c = c;
            this.v = v;
            this.t = t;
        }
    }
}