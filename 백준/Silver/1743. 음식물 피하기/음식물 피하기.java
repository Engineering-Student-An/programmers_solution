import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = 1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(arr[i][j] == 1) queue.add(bfs(i, j));
            }
        }

        System.out.println(queue.poll());
    }

    static int bfs(int i, int j) {
        int count = 0;

        arr[i][j] = 0;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(i, j));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            count ++;

            for (int k = 0; k < 4; k++) {
                int nextRow = now.row + dirRow[k];
                int nextCol = now.col + dirCol[k];

                if(nextRow > 0 && nextCol > 0 && nextRow <= n && nextCol <= m && arr[nextRow][nextCol] == 1) {
                    arr[nextRow][nextCol] = 0;
                    queue.add(new Info(nextRow, nextCol));
                }
            }
        }

        return count;
    }

    static class Info {
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}