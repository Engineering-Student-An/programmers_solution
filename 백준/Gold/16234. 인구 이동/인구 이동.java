import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, l, r;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            boolean move = false;

            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visit[i][j]) {
                        boolean chk = bfs(i, j);
                        move = move || chk;
                    }
                }
            }
            if(!move) break;
            ans ++;
        }
        System.out.println(ans);
    }

    static boolean bfs(int row, int col) {

        int sum = 0;
        List<Info> infos = new ArrayList<>();

        visit[row][col] = true;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(row, col));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            infos.add(new Info(now.row, now.col));
            sum += arr[now.row][now.col];
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dirRow[i];
                int nextCol = now.col + dirCol[i];

                if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n && !visit[nextRow][nextCol]) {
                    int diff = Math.abs(arr[now.row][now.col] - arr[nextRow][nextCol]);
                    if(diff >= l && diff <= r) {
                        visit[nextRow][nextCol] = true;
                        queue.add(new Info(nextRow, nextCol));
                    }
                }
            }
        }

        if(infos.size() > 1) {
            int newNum = sum / infos.size();
            for (Info info : infos) {
                arr[info.row][info.col] = newNum;
            }
            return true;
        } else {
            return false;
        }
    }

    static class Info {
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}