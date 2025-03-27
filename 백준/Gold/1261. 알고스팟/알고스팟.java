import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static long[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        result = new long[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
                result[i][j] = Long.MAX_VALUE;
            }
        }

        dijkstra();

        System.out.println(result[n-1][m-1]);
    }

    static void dijkstra() {

        int[] nextRow = {0, 1, 0, -1};
        int[] nextCol = {1, 0, -1, 0};

        result[0][0] = 0;
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.value, o2.value));
        queue.add(new Info(0, 0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            int i = now.row;
            int j = now.col;

            if(result[i][j] < now.value) continue;

            for (int k = 0; k < 4; k++) {
                int nextI = i + nextRow[k];
                int nextJ = j + nextCol[k];

                if(nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= m) continue;

                if(result[nextI][nextJ] > result[i][j] + (long) arr[nextI][nextJ]) {
                    result[nextI][nextJ] = result[i][j] + (long) arr[nextI][nextJ];
                    queue.add(new Info(nextI, nextJ, result[nextI][nextJ]));
                }

            }
        }
    }

    static class Info {
        int row;
        int col;
        long value;

        public Info(int row, int col, long value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}