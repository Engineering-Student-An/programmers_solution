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
    static int[] nextRow = {0, 1, 0, -1};
    static int[] nextCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (line.charAt(j) == '1');
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0, 0);

        System.out.println(result[n-1][m-1]);
    }

    static void bfs(int i, int j) {

        Queue<Info> queue = new LinkedList<>();
        result[i][j] = 1;
        queue.add(new Info(i, j));

        while (!queue.isEmpty()) {
            Info poll = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ni = poll.i + nextRow[k];
                int nj = poll.j + nextCol[k];

                if(ni >= 0 && ni < n && nj >= 0 && nj < m && arr[ni][nj] && result[ni][nj] == Integer.MAX_VALUE) {
                    result[ni][nj] = result[poll.i][poll.j] + 1;
                    queue.add(new Info(ni, nj));
                }
            }
        }
    }

    static class Info {
        int i;
        int j;

        public Info(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}