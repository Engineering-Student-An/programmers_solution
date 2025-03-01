import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][][] visit;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();
    }

    static void bfs() {

        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};

        boolean found = false;
        visit[0][0][0] = true;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0, 0, 1, false));

        while (!queue.isEmpty()) {

            Info info = queue.poll();

            if(info.row == n-1 && info.col == m-1) {
                System.out.println(info.value);
                found = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = info.row + rowDir[i];
                int nextCol = info.col + colDir[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) continue;

                if(arr[nextRow][nextCol] == 0) {
                    if(!info.broke && !visit[0][nextRow][nextCol]) {
                        visit[0][nextRow][nextCol] = true;
                        queue.add(new Info(nextRow, nextCol, info.value + 1, false));
                    } else if(info.broke && !visit[1][nextRow][nextCol]) {
                        visit[1][nextRow][nextCol] = true;
                        queue.add(new Info(nextRow, nextCol, info.value + 1, true));
                    }
                } else {
                    if(!info.broke) {
                        visit[1][nextRow][nextCol] = true;
                        queue.add(new Info(nextRow, nextCol, info.value + 1, true));
                    }
                }
            }
        }

        if(found) return;
        System.out.println(-1);
    }

    static class Info {
        int row;
        int col;
        int value;
        boolean broke;

        public Info(int row, int col, int value, boolean broke) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.broke = broke;
        }
    }
}