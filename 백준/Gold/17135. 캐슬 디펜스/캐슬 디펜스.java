import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, d, count, result = Integer.MIN_VALUE;
    static int[][] original, arr;
    static int[] dirRow = {0, -1, 0};
    static int[] dirCol = {-1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        original = new int[n + 1][m];
        arr = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
                if(original[i][j] == 1) count ++;
            }
        }

        for (int a = 0; a < m - 2; a++) {
            for (int b = a + 1; b < m - 1; b++) {
                for (int c = b + 1; c < m; c++) {

                    copy();

                    int enemies = count;
                    int dieCount = 0;
                    while(enemies > 0) {
                        // 궁수가 활 쏨
                        Info aa = defence(a);
                        Info bb = defence(b);
                        Info cc = defence(c);

                        // 적이 죽음
                        if(aa != null) {
                            arr[aa.r][aa.c] = 0;
                            dieCount ++;
                        }
                        if(bb != null && arr[bb.r][bb.c] != 0) {
                            arr[bb.r][bb.c] = 0;
                            dieCount ++;
                        }
                        if(cc != null && arr[cc.r][cc.c] != 0) {
                            arr[cc.r][cc.c] = 0;
                            dieCount ++;
                        }

                        // 적이 한칸씩 내려옴
                        enemies = move();
                    }
                    result = Math.max(result, dieCount);
                }
            }
        }

        System.out.println(result);
    }

    static int move() {
        int count = 0;

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    if(i < n - 1) {
                        arr[i+1][j] = 1;
                        count ++;
                    }
                    arr[i][j] = 0;
                }
            }
        }

        return count;
    }

    static Info defence(int a) {

        boolean[][] visit = new boolean[n][m];

        PriorityQueue<Info> queue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.d == o2.d) return o1.c - o2.c;
                return o1.d - o2.d;
            }
        });

        queue.add(new Info(n, a, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && now.d + 1 <= d && !visit[nr][nc]) {
                    if(arr[nr][nc] == 1) return new Info(nr, nc);
                    queue.add(new Info(nr, nc, now.d + 1));
                    visit[nr][nc] = true;
                }
            }
        }

        return null;
    }

    static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = original[i][j];
            }
        }
    }

    static class Info {
        int r, c;
        int d;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Info(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

}