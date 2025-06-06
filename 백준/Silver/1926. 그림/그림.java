import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dirRow = {0, 1, 0, -1};
        int[] dirCol = {1, 0, -1, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] = 0;
                    Queue<Info> queue = new LinkedList<>();
                    queue.add(new Info(i, j));

                    int area = 0;
                    while (!queue.isEmpty()) {
                        Info now = queue.poll();
                        area ++;
                        for (int k = 0; k < 4; k++) {
                            int nextRow = now.row + dirRow[k];
                            int nextCol = now.col + dirCol[k];

                            if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] == 1) {
                                arr[nextRow][nextCol] = 0;
                                queue.add(new Info(nextRow, nextCol));
                            }
                        }
                    }

                    pq.add(area);
                }
            }
        }

        System.out.println(pq.size());
        System.out.println(pq.size() > 0 ? pq.poll() : 0);
    }

    static class Info {
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}