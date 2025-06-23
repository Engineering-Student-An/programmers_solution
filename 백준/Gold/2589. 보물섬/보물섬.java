import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] arr;
    static int[][] result;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) == 'L';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]) bfs(i, j);
            }
        }

        System.out.println(max);
    }

    static void bfs(int r, int c) {
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        result[r][c] = 0;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            max = Math.max(max, result[now.r][now.c]);

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dirRow[i];
                int nextC = now.c + dirCol[i];

                if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && arr[nextR][nextC]
                        && result[nextR][nextC] > result[now.r][now.c] + 1) {
                    result[nextR][nextC] = result[now.r][now.c] + 1;
                    queue.add(new Info(nextR, nextC));
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