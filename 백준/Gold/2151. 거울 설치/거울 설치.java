import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};
    static int[][] result;
    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Info start = null;
        Info end = null;

        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == '#' && start == null) start = new Info(i, j, 0, 0);
                if(arr[i][j] == '#' && start != null) end = new Info(i, j, 0, 0);
            }
        }

        result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        result[start.r][start.c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = start.r + dirRow[i];
            int nc = start.c + dirCol[i];
            if(nr >= 0 && nc >= 0 && nr < n && nc < n && arr[nr][nc] != '*') {
                queue.add(new Info(start.r, start.c, 0, i));
            }
        }

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            
            if(result[now.r][now.c] < now.count) continue;

            // 거울 설치 x -> 방향 유지해서 다음칸 체크
            int nr = now.r;
            int nc = now.c;
            while(true) {
                nr += dirRow[now.dir];
                nc += dirCol[now.dir];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n && arr[nr][nc] != '*') {
                    if(result[nr][nc] > now.count) {
                        result[nr][nc] = now.count;
                        queue.add(new Info(nr, nc, result[nr][nc], now.dir));
                    }
                } else break;
            }


            // 거울 설치 가능한 경우 설치 -> 거울 방향으로 꺾어서 체크
            if(arr[now.r][now.c] == '!') {
                for (int k = 1; k <= 3; k+=2) {
                    int dir = (now.dir + k) % 4;

                    nr = now.r;
                    nc = now.c;
                    while(true) {
                        nr += dirRow[dir];
                        nc += dirCol[dir];
                        if (nr >= 0 && nc >= 0 && nr < n && nc < n && arr[nr][nc] != '*') {
                            if(result[nr][nc] > now.count + 1) {
                                result[nr][nc] = now.count + 1;
                                queue.add(new Info(nr, nc, result[nr][nc], dir));
                            }
                        } else break;
                    }
                }                
            }
        }

        System.out.println(result[end.r][end.c]);
    }

    static class Info {
        int r, c, count, dir;

        public Info(int r, int c, int count, int dir) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.dir = dir;
        }
    }
}