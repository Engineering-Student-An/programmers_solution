import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, result = 0, dir = 0;
    static int r = 0, c = 0;
    static int[] dice = {1, 5, 6, 2, 3, 4};
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};    // 동, 남, 서, 북
    static int[][] arr, score;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        score = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(score[i][j] == 0) findScore(new Info(i, j));
            }
        }

        while(k -- > 0) {
            move();
        }

        System.out.println(result);
    }

    static void move() {

        int nr = r + dirRow[dir];
        int nc = c + dirCol[dir];

        // 칸이 없다면 반대 방향으로 이동
        if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
            dir = (dir < 2) ? dir + 2 : dir - 2;
            nr = r + dirRow[dir];
            nc = c + dirCol[dir];
        }
        // (동, 남, 서, 북) 이동
        if(dir == 0) {
            dice[4] = dice[0];
            dice[0] = dice[5];

            dice[5] = 7 - dice[4];
            dice[2] = 7 - dice[0];
        } else if(dir == 1) {
            dice[1] = dice[0];
            dice[0] = dice[3];

            dice[2] = 7 - dice[0];
            dice[3] = 7 - dice[1];
        } else if(dir == 2) {
            dice[5] = dice[0];
            dice[0] = dice[4];

            dice[2] = 7 - dice[0];
            dice[4] = 7 - dice[5];
        } else {
            dice[3] = dice[0];
            dice[0] = dice[1];

            dice[1] = 7 - dice[3];
            dice[2] = 7 - dice[0];
        }

        // 점수 획득
        result += score[nr][nc];

        // 방향 바꾸기
        r = nr;
        c = nc;

        if(dice[2] > arr[r][c]) {
            dir = (dir + 1) % 4;
        } else if(dice[2] < arr[r][c]) {
            dir = (dir + 3) % 4;
        }
    }

    static void findScore(Info first) {

        int count = 1;

        boolean[][] visit = new boolean[n][m];
        visit[first.r][first.c] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(first);

        List<Info> list = new ArrayList<>();
        list.add(first);

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m 
                        && arr[nr][nc] == arr[first.r][first.c] && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    count ++;
                    Info info = new Info(nr, nc);
                    list.add(info);
                    queue.add(info);
                }
            }
        }

        for (Info info : list) {
            score[info.r][info.c] = count * arr[first.r][first.c];
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