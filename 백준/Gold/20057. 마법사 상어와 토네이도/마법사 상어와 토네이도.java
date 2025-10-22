import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Info[][] move = new Info[4][10];
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int originalSum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                originalSum += arr[i][j];
            }
        }

        int r = n/2, c = n/2;
        int dir = 0, seq = 1;

        for (int i = 0; i < 4; i++) {
            move[i][0] = new Info(dirRow[(i + 1) % 4], dirCol[(i + 1) % 4], 1);
            move[i][1] = new Info(dirRow[(i + 3) % 4], dirCol[(i + 3) % 4], 1);
            move[i][2] = new Info(dirRow[i] + dirRow[(i + 1) % 4], dirCol[i] + dirCol[(i + 1) % 4], 7);
            move[i][3] = new Info(dirRow[i] + dirRow[(i + 3) % 4], dirCol[i] + dirCol[(i + 3) % 4], 7);
            move[i][4] = new Info(dirRow[i] + 2 * dirRow[(i + 1) % 4], dirCol[i] + 2 * dirCol[(i + 1) % 4], 2);
            move[i][5] = new Info(dirRow[i] + 2 * dirRow[(i + 3) % 4], dirCol[i] + 2 * dirCol[(i + 3) % 4], 2);
            move[i][6] = new Info(2 * dirRow[i] + dirRow[(i + 1) % 4], 2 * dirCol[i] + dirCol[(i + 1) % 4], 10);
            move[i][7] = new Info(2 * dirRow[i] + dirRow[(i + 3) % 4], 2 * dirCol[i] + dirCol[(i + 3) % 4], 10);
            move[i][8] = new Info(3 * dirRow[i], 3 * dirCol[i], 5);
            move[i][9] = new Info(2 * dirRow[i], 2 * dirCol[i], 0);
        }
        while(true) {
            if(r == 0 && c == 0) break;

            int times = 2;
            if(seq == n - 1) times ++;
            for (int i = 0; i < times; i++) {
                for (int j = 0; j < seq; j++) {
                    move(r, c, dir);
                    r = r + dirRow[dir];
                    c = c + dirCol[dir];
                }
                dir = (dir + 1) % 4;
            }

            seq ++;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(originalSum - sum);
    }

    static void move(int r, int c, int dir) {

        int sand = arr[r + dirRow[dir]][c + dirCol[dir]];
        int moveSum = 0;

        for (int i = 0; i < 9; i++) {
            int nr = r + move[dir][i].r;
            int nc = c + move[dir][i].c;

            int moveSand = sand * move[dir][i].percent / 100;
            moveSum += moveSand;
            if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                arr[nr][nc] += moveSand;
            }
        }

        int nr = r + move[dir][9].r;
        int nc = c + move[dir][9].c;
        if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
            arr[nr][nc] += (sand - moveSum);
        }

        arr[r + dirRow[dir]][c + dirCol[dir]] = 0;
    }

    static class Info {
        int r, c, percent;

        public Info(int r, int c, int percent) {
            this.r = r;
            this.c = c;
            this.percent = percent;
        }
    }
}