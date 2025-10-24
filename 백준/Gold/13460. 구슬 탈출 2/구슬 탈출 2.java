import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] arr;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        Info red = null, blue = null;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);

                if(c == 'R') red = new Info(i, j);
                else if(c == 'B') blue = new Info(i, j);
                arr[i][j] = (c == 'R' || c == 'B') ? '.' : c;
            }
        }

        System.out.println(bfs(red, blue));


    }

    static int bfs(Info red, Info blue) {

        Move start = new Move(red, blue, 0);
        Queue<Move> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Move now = queue.poll();

            if(now.count == 10) return -1;

            for (int k = 0; k < 4; k++) {
                Info moveRed = null, moveBlue = null;

                // 움직이는 순서가 중요한 경우
                if(k == 0 && now.red.r == now.blue.r) {    // 우
                    if(now.red.c > now.blue.c) {
                        // 빨간색 먼저 움직이기
                        moveRed = move(now.red, k);

                        // 파란색은 빨간색을 주의하며 움직이기
                        moveBlue = moveAfter(now.blue, k, moveRed);
                    } else {
                        // 파란색
                        moveBlue = move(now.blue, k);
                        // 빨간색은 나중에
                        moveRed = moveAfter(now.red, k, moveBlue);
                    }
                } else if(k == 1 && now.red.c == now.blue.c) {  // 하
                    if(now.red.r > now.blue.r) {
                        moveRed = move(now.red, k);
                        moveBlue = moveAfter(now.blue, k, moveRed);
                    } else {
                        moveBlue = move(now.blue, k);
                        moveRed = moveAfter(now.red, k, moveBlue);
                    }
                } else if(k == 2 && now.red.r == now.blue.r) {  // 좌
                    if(now.red.c < now.blue.c) {
                        moveRed = move(now.red, k);
                        moveBlue = moveAfter(now.blue, k, moveRed);
                    } else {
                        moveBlue = move(now.blue, k);
                        moveRed = moveAfter(now.red, k, moveBlue);
                    }
                } else if(k == 3 && now.red.c == now.blue.c) {  // 상
                    if(now.red.r < now.blue.r) {
                        moveRed = move(now.red, k);
                        moveBlue = moveAfter(now.blue, k, moveRed);
                    } else {
                        moveBlue = move(now.blue, k);
                        moveRed = moveAfter(now.red, k, moveBlue);
                    }
                } else {
                    moveRed = move(now.red, k);
                    moveBlue = move(now.blue, k);
                }

                boolean isRed = (moveRed.r == 0 && moveRed.c == 0);
                boolean isBlue = (moveBlue.r == 0 && moveBlue.c == 0);

                if(isRed && !isBlue) return now.count + 1;
                else if(isRed && isBlue) continue;
                else if(!isRed && isBlue) continue;

                if(moveRed.r != now.red.r || moveRed.c != now.red.c || moveBlue.r != now.blue.r || moveBlue.c != now.blue.c)  queue.add(new Move(moveRed, moveBlue, now.count + 1));
            }
        }

        return -1;
    }

    static Info moveAfter(Info now, int k, Info before) {
        // 공 움직이기
        int r = now.r;
        int c = now.c;

        while(arr[r + dirRow[k]][c + dirCol[k]] == '.' && (r + dirRow[k] != before.r || c + dirCol[k] != before.c)) {
            r += dirRow[k];
            c += dirCol[k];
        }

        if(arr[r + dirRow[k]][c + dirCol[k]] == 'O') return new Info(0, 0);
        return new Info(r, c);
    }

    static Info move(Info now, int k) {
        // 공 움직이기
        int r = now.r;
        int c = now.c;

        while(arr[r + dirRow[k]][c + dirCol[k]] == '.') {
            r += dirRow[k];
            c += dirCol[k];
        }

        if(arr[r + dirRow[k]][c + dirCol[k]] == 'O') return new Info(0, 0);
        return new Info(r, c);
    }

    static class Move {
        Info red, blue;
        int count;

        public Move(Info red, Info blue, int count) {
            this.red = red;
            this.blue = blue;
            this.count = count;
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