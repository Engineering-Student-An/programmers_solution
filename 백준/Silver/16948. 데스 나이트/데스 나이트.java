import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[] dirRow = {-2, -2, 0, 0, 2, 2};
    static int[] dirCol = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Info start = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Info end = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        arr[start.r][start.c] = 0;

        int result = bfs(start, end);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static int bfs(Info start, Info end) {
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        queue.add(new Info(start.r, start.c, 0));


        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && arr[nr][nc] == Integer.MAX_VALUE) {
                    arr[nr][nc] = now.count + 1;
                    if(nr == end.r && nc == end.c) return arr[nr][nc];
                    queue.add(new Info(nr, nc, arr[nr][nc]));
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Info {
        int r, c, count;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Info(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}