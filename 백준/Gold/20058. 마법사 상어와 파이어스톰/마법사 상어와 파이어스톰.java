import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};
    static int[][] arr, temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2, n);
        int Q = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while(Q -- > 0) {
            int l = Integer.parseInt(st.nextToken());
            l = (int) Math.pow(2, l);

            // 시계방향으로 90도 회전
            temp = new int[n][n];
            for (int i = 0; i < n; i+=l) {
                for (int j = 0; j < n; j+=l) {
                    turn(i, j, l);
                }
            }

            // 원래 배열에 회전한 결과 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = temp[i][j];
                }
            }

            // 얼음 녹기
            remove();
        }

        int sum = 0, max = 0;
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] > 0) {
                    sum += arr[i][j];
                    if(!visit[i][j]) max = Math.max(max, bfs(i, j, visit));
                }
            }
        }
        System.out.println(sum);
        System.out.println(max);
    }
    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int bfs(int r, int c, boolean[][] visit) {

        visit[r][c] = true;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));

        int count = 1;
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && !visit[nr][nc] && arr[nr][nc] > 0) {
                    count ++;
                    queue.add(new Info(nr, nc));
                    visit[nr][nc] = true;
                }
            }
        }

        return count;
    }

    static void remove() {
        int[][] plus = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int ni = i + dirRow[k];
                    int nj = j + dirCol[k];
                    if(ni >= 0 && nj >= 0 && ni < n && nj < n && arr[ni][nj] > 0) {
                        count ++;
                    }
                }

                if(count < 3) plus[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] += plus[i][j];
            }
        }
    }

    static void turn(int r, int c, int l) {
        int re = r + l - 1;
        int ce = c + l - 1;

        for (int i = r; i <= re; i++) {
            for (int j = c; j <= ce; j++) {
                temp[re - (ce - j)][ce - (i - r)] = arr[i][j];
            }
        }
    }
}
