import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static PriorityQueue<Info> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if(c == '#') arr[i][j] = -1;
                else if(c == 'J') {
                    arr[i][j] = 1;
                    queue.add(new Info(i, j, 1, 0));
                }
                else if(c == 'F') {
                    arr[i][j] = 2;
                    queue.add(new Info(i, j, 2, 0));
                }
            }
        }

        int result = fire();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    static int fire() {

//        int count = 1;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(now.type == 1) {     // 사람 움직이기
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                        return now.second + 1;
                    } else if (arr[nr][nc] == 0) {
                        arr[nr][nc] = 1;
                        queue.add(new Info(nr, nc, 1, now.second + 1));
//                        count ++;
                    }
                } else {                // 불 움직이기
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] != -1 && arr[nr][nc] != 2) {
//                        if(arr[nr][nc] == 1) count --;
                        arr[nr][nc] = 2;
                        queue.add(new Info(nr, nc, 2, now.second + 1));
                    }
                }
            }

//            if(count <= 0) return -1;
        }

        return -1;
    }

    static class Info implements Comparable<Info> {
        int r, c, type, second;

        @Override
        public int compareTo(Info o) {
            if(this.second == o.second) return o.type - this.type;
            return this.second - o.second;
        }

        public Info(int r, int c, int type, int second) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.second = second;
        }
    }
}