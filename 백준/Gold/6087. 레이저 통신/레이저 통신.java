import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] arr;
    static Info[] dest = new Info[2];
    static int[][][] result;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'C' && dest[0] == null) dest[0] = new Info(i, j);
                else if(arr[i][j] == 'C' && dest[0] != null) dest[1] = new Info(i, j);
            }
        }

        result = new int[n][m][4];

        dijkstra(dest[0]);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(result[i][j] + " ");
//            }
//            System.out.println();
//        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, result[dest[1].r][dest[1].c][i]);
        }
        System.out.println(min);
    }

    static void dijkstra(Info start) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    result[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            result[start.r][start.c][i] = 0;
        }

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        for (int i = 0; i < 4; i++) {
            queue.add(new Info(start.r, start.c, 0, i));
        }

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.r][now.c][now.index] < now.count) continue;

            // 방향 유지
            int nextR = now.r + dirRow[now.index];
            int nextC = now.c + dirCol[now.index];

            if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && arr[nextR][nextC] != '*'
                    && result[nextR][nextC][now.index] > now.count) {
                result[nextR][nextC][now.index] = now.count;
                queue.add(new Info(nextR, nextC, now.count, now.index));
            }

            // 90도 시계 방향
            int index = (now.index + 1) % 4;
            nextR = now.r + dirRow[index];
            nextC = now.c + dirCol[index];

            if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && arr[nextR][nextC] != '*'
                    && result[nextR][nextC][index] > now.count + 1) {
                result[nextR][nextC][index] = now.count + 1;
                queue.add(new Info(nextR, nextC, now.count + 1, index));
            }

            // 90도 반시계 방향
            index = (now.index + 3) % 4;
            nextR = now.r + dirRow[index];
            nextC = now.c + dirCol[index];

            if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && arr[nextR][nextC] != '*'
                    && result[nextR][nextC][index] > now.count + 1) {
                result[nextR][nextC][index] = now.count + 1;
                queue.add(new Info(nextR, nextC, now.count + 1, index));
            }
        }
    }

    static class Info {
        int r, c, count, index;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Info(int r, int c, int count, int index) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.index = index;
        }
    }
}