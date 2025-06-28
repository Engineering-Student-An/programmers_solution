import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int k, n, m;
    static int[][] arr;
    static Info[] dir = {new Info(0, 1), new Info(1, 0), new Info(0, -1), new Info(-1, 0)};
    static Info[] hDir = {new Info(1, 2), new Info(2, 1), new Info(2, -1), new Info(1, -2),
            new Info(-1, -2), new Info(-2, -1), new Info(-2, 1), new Info(-1, 2)};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int distance = bfs();
        System.out.println(distance == Integer.MAX_VALUE ? -1 : distance);
    }

    static int bfs() {

        if(n == 1 && m == 1) return 0;

        List<Info>[][] result = new ArrayList[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = new ArrayList<>();
            }
        }
        result[0][0].add(new Info(0, 0, 0, 0));

        PriorityQueue<Info> queue = new PriorityQueue<>(((o1, o2) -> {
            if(o1.count == o2.count) return Integer.compare(o1.h, o2.h);
            return Integer.compare(o1.count, o2.count);
        }));
        queue.add(new Info(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(now.h < k) {
                for (Info info : hDir) {
                    int nr = now.r + info.r;
                    int nc = now.c + info.c;
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == 0) {
                        boolean chk = true;
                        for (Info next : result[nr][nc]) {
                            if (now.count + 1 >= next.count && now.h + 1 >= next.h) {
                                chk = false;
                                break;
                            }
                        }

                        if(chk) {
                            if (nr == n - 1 && nc == m - 1) return now.count + 1;
                            result[nr][nc].add(new Info(nr, nc, now.h+1, now.count + 1));
                            queue.add(new Info(nr, nc, now.h + 1, now.count + 1));
                        }
                    }
                }
            }

            for (Info info : dir) {
                int nr = now.r + info.r;
                int nc = now.c + info.c;
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == 0) {

                    boolean chk = true;
                    for (Info next : result[nr][nc]) {
                        if (now.count + 1 >= next.count && now.h >= next.h) {
                            chk = false;
                            break;
                        }
                    }

                    if(chk) {
                        if (nr == n - 1 && nc == m - 1) return now.count + 1;
                        result[nr][nc].add(new Info(nr, nc, now.h, now.count + 1));
                        queue.add(new Info(nr, nc, now.h, now.count + 1));
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Info {
        int r, c, h, count;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Info(int r, int c, int h, int count) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.count = count;
        }
    }
}