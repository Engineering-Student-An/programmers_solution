import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};
    static int[][] bomb;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        List<Info> possible = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) possible.add(new Info(i, j));
            }
        }

        bomb = new int[n][n];
        bombPosition(possible, 0, -1);

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    static int bfs() {

        Queue<Info> queue = new LinkedList<>();

        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(bomb[i][j] == 1) queue.add(new Info(i, j, 1));
                temp[i][j] = bomb[i][j];
            }
        }

        int max = -1;
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            max = Math.max(max, now.count);

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n && arr[nr][nc] != 1 && temp[nr][nc] == 0) {
                    temp[nr][nc] = now.count + 1;
                    queue.add(new Info(nr, nc, temp[nr][nc]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(temp[i][j] == 0 && arr[i][j] != 1) return Integer.MAX_VALUE;
            }
        }

        return max - 1;
    }

    static void bombPosition(List<Info> possible, int count, int index) {
        if(count == m) {
            result = Math.min(result, bfs());
            return;
        }

        for (int i = index + 1; i < possible.size(); i++) {
            Info info = possible.get(i);
            bomb[info.r][info.c] = 1;
            bombPosition(possible, count + 1, i);
            bomb[info.r][info.c] = 0;
        }
    }

    static class Info {
        int r, c;
        int count;

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