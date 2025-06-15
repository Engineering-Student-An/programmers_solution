import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] isOutside;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) count ++;
            }
        }

        isOutside = new boolean[n][m];
        int days = 0;
        while(count > 0) {
            // 외부인지 확인
            checkOutside();

            // 하루가 지남
            days ++;

            for (int i = 1; i < n-1; i++) {
                for (int j = 1; j < m-1; j++) {
                    int check = 0;
                    if(arr[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            int nextI = i + dirRow[k];
                            int nextJ = j + dirCol[k];

                            if (arr[nextI][nextJ] == 0 && isOutside[nextI][nextJ]) {
                                check++;
                            }
                        }

                        if (check >= 2) {
                            arr[i][j] = 0;
                            count--;
                        }
                    }
                }
            }
        }
        System.out.println(days);
    }

    static void checkOutside() {
        isOutside = new boolean[n][m];
        isOutside[0][0] = true;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = now.row + dirRow[i];
                int nextC = now.col + dirCol[i];

                if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && arr[nextR][nextC] == 0 && !isOutside[nextR][nextC]) {
                    isOutside[nextR][nextC] = true;
                    queue.add(new Info(nextR, nextC));
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