import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][][] arr = new int[9][8][8];
    static int[] dirRow = {0, 0, 1, 1, 1, 0, -1, -1, -1}, dirCol = {0, 1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[0][i][j] = (line.charAt(j) == '.') ? 0 : 1;
            }
        }

        for (int k = 1; k < 9; k++) {
            for (int i = 6; i >= 0; i--) {
                for (int j = 0; j < 8; j++) {
                    if(arr[k-1][i][j] == 1) {
                        arr[k][i + 1][j] = 1;
                    }
                }
            }
        }

        System.out.println(bfs() ? "1" : "0");
    }

    static boolean bfs() {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(7, 0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(now.second >= 8) return true;

            if(arr[now.second][now.r][now.c] == 1) continue;

//            System.out.println("(" + now.r + ", " + now.c + ") => " + now.second);

            for (int i = 0; i < 9; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < 8 && nc < 8 && arr[now.second + 1][nr][nc] == 0 && arr[now.second][nr][nc] == 0) {
                    queue.add(new Info(nr, nc, now.second + 1));
                }
            }
        }

        return false;
    }

    static class Info {
        int r, c, second;

        public Info(int r, int c, int second) {
            this.r = r;
            this.c = c;
            this.second = second;
        }
    }
}