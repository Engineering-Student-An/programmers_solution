import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙산 주변의 바다 카운트
//        seaCount = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if(arr[i][j] > 0) {
//                    for (int k = 0; k < 4; k++) {
//                        int nextRow = i + dirRow[k];
//                        int nextCol = j + dirCol[k];
//                        if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] == 0) seaCount[i][j] ++;
//                    }
//                }
//            }
//        }

        int ans = 0;
        int partCount = 0;
        while(true) {
            ans ++;

            // 주변 바다 수 체크
            int[][] minusCount = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] > 0) {
                        for (int k = 0; k < 4; k++) {
                            int nextRow = i + dirRow[k];
                            int nextCol = j + dirCol[k];
                            if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] == 0) minusCount[i][j] ++;
                        }
                    }
                }
            }

            // 빙하 녹기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Math.max(0, arr[i][j] - minusCount[i][j]);
                }
            }

            // 빙하 분리 여부 체크
            partCount = 0;
            visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] > 0 && !visit[i][j]) {
                        bfs(i, j);
                        partCount ++;
                    }
                }
            }
            if(partCount != 1) break;
        }

        System.out.println(partCount == 0 ? 0 : ans);
    }

    static void bfs(int r, int c) {
        visit[r][c] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextRow = now.row + dirRow[k];
                int nextCol = now.col + dirCol[k];
                if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] > 0 && !visit[nextRow][nextCol]) {
                    visit[nextRow][nextCol] = true;
                    queue.add(new Info(nextRow, nextCol));
                }
            }
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