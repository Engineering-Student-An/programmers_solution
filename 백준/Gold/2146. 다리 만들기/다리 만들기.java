import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static boolean[][] visit;
    static int distance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 1;
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] != 0 && !visit[i][j]) {
                    islandNum(num, i, j);
                    num ++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dirRow[k];
                        int nc = j + dirCol[k];

                        // 바다 시작점
                        if (nr >= 0 && nc >= 0 && nr < n && nc < n && arr[nr][nc] == 0) {
                            build(arr[i][j], nr, nc);
                        }
                    }
                }
            }
        }

        System.out.println(distance);
    }

    static void build(int num, int r, int c) {

        int[][] dist = new int[n][n];
        dist[r][c] = 1;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n && arr[nr][nc] == 0 && dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                    queue.add(new Info(nr, nc));
                } else if(nr >= 0 && nc >= 0 && nr < n && nc < n && arr[nr][nc] != 0 && arr[nr][nc] != num) {
                    distance = Math.min(distance, dist[now.r][now.c]);
                    return;
                }
            }

        }
    }

    static void islandNum(int num, int r, int c) {

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));
        visit[r][c] = true;
        arr[r][c] = num;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n && arr[nr][nc] != 0 && !visit[nr][nc]) {
                    arr[nr][nc] = num;
                    visit[nr][nc] = true;
                    queue.add(new Info(nr, nc));
                }
            }
        }
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}