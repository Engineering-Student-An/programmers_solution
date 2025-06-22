import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr, result;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken()) - 1;
        int startC = Integer.parseInt(st.nextToken()) - 1;
        int endR = Integer.parseInt(st.nextToken()) - 1;
        int endC = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        arr[startR][startC] = 1;
        arr[endR][endC] = 1;

        result = new int[n][m];

        dijkstra(startR, startC);

        System.out.println(result[endR][endC]);
    }

    static void dijkstra(int startR, int startC) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        result[startR][startC] = 0;
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
        queue.add(new Info(startR, startC, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.r][now.c] < now.v) continue;

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dirRow[i];
                int nextC = now.c + dirCol[i];

                if(arr[now.r][now.c] == 1) {
                    if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && result[nextR][nextC] > now.v + 1) {
                        result[nextR][nextC] = now.v + 1;
                        queue.add(new Info(nextR, nextC, result[nextR][nextC]));
                    }
                } else {
                    if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && result[nextR][nextC] > now.v) {
                        result[nextR][nextC] = now.v;
                        queue.add(new Info(nextR, nextC, result[nextR][nextC]));
                    }
                }
            }
        }
    }

    static class Info {
        int r, c, v;

        public Info(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
}