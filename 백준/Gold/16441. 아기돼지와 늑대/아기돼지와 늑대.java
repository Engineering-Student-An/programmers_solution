import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};
    static boolean[][] visit;
    static boolean[][][] iceVisit;
    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        List<Info> wolves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'W') {
                    wolves.add(new Info(i, j));
                    arr[i][j] = '.';
                }
            }
        }

        visit = new boolean[n][m];
        iceVisit = new boolean[4][n][m];
        for (Info info : wolves) {
            bfs(info);
        }

        StringBuilder sb = new StringBuilder();
        char[][] result = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && arr[i][j] == '.') result[i][j] = 'P';
                else result[i][j] = arr[i][j];
            }
        }

        for (Info info : wolves) {
            result[info.r][info.c] = 'W';
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(Info start) {
        visit[start.r][start.c] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                if(arr[nr][nc] == '.' && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    queue.add(new Info(nr, nc));
                } else if(arr[nr][nc] == '+' && !iceVisit[i][nr][nc]) {
                    char next = ' ';
                    iceVisit[i][nr][nc] = true;
                    while(nr + dirRow[i] >= 0 && nc + dirCol[i] >= 0 && nr + dirRow[i] < n && nc + dirCol[i] < m) {

                        nr += dirRow[i];
                        nc += dirCol[i];

                        iceVisit[i][nr][nc] = true;
                        next = arr[nr][nc];
                        if(arr[nr][nc] == '.') {
                            break;
                        } else if(arr[nr][nc] == '#') {
                            nr -= dirRow[i];
                            nc -= dirCol[i];
                            break;
                        }
                    }

                    if(next == '.' && !visit[nr][nc]) { // 초원
                        visit[nr][nc] = true;
                        queue.add(new Info(nr, nc));
                    } else if(next == '#' || next == '+') {    // 산 이전 칸 빙판 (+ 생빙판)
                        queue.add(new Info(nr, nc));
                    }
                }
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