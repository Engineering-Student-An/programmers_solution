import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] outside;
    static int count = 0;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        outside = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) count ++;
            }
        }

        int time = 0;
        int beforeZero = 0;
        while(count > 0) {
            time ++;
            isOutside();
            beforeZero = count;
            cheese();
        }

        System.out.println(time);
        System.out.println(beforeZero);
    }

    static void cheese() {
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                boolean melt = false;

                if(arr[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nextI = i + dirRow[k];
                        int nextJ = j + dirCol[k];
                        if(outside[nextI][nextJ]) {
                            melt = true;
                            break;
                        }
                    }
                }

                if(melt) {
                    arr[i][j] = 0;
                    count --;
                }
            }
        }
    }

    static void isOutside() {

        int r = 0;
        int c = 0;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));
        boolean[][] visit = new boolean[n][m];
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dirRow[i];
                int nextC = now.c + dirCol[i];

                if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && arr[nextR][nextC] == 0 && !visit[nextR][nextC]) {
                    queue.add(new Info(nextR, nextC));
                    visit[nextR][nextC] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                outside[i][j] = visit[i][j];
            }
        }
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}