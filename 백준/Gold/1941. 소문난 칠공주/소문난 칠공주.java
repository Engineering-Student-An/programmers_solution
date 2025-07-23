import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] arr = new char[5][5];
    static int result = 0;
    static boolean[][] visit = new boolean[5][5];
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                visit[i][j] = true;
                if(arr[i][j] == 'Y') choose(i, j, 1, 0);
                else choose(i, j, 0, 1);
                visit[i][j] = false;
            }
        }

        System.out.println(result);
    }

    static void choose(int r, int c, int y, int s) {

        if(y + s == 7) {
            if(s > y && bfs()) result ++;
            return;
        }

        for (int i = r; i < 5; i++) {
            if(i == r) {
                for (int j = c+1; j < 5; j++) {
                    if(arr[i][j] == 'Y' && y < 3 && !visit[i][j]) {
                        visit[i][j] = true;
                        choose(i, j, y+1, s);
                        visit[i][j] = false;
                    }
                    else if(arr[i][j] == 'S' && !visit[i][j]){
                        visit[i][j] = true;
                        choose(i, j, y, s + 1);
                        visit[i][j] = false;
                    }
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    if(arr[i][j] == 'Y' && y < 3 && !visit[i][j]) {
                        visit[i][j] = true;
                        choose(i, j, y+1, s);
                        visit[i][j] = false;
                    }
                    else if(arr[i][j] == 'S' && !visit[i][j]){
                        visit[i][j] = true;
                        choose(i, j, y, s + 1);
                        visit[i][j] = false;
                    }
                }
            }
        }
    }

    static boolean bfs() {
        Queue<Info> queue = new LinkedList<>();

        boolean[][] nowVisit = new boolean[5][5];
        boolean first = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(visit[i][j]) {
                    queue.add(new Info(i, j));
                    nowVisit[i][j] = true;
                    first = true;
                    break;
                }
            }
            if(first) break;
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            count ++;

            if(count == 7) break;

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < 5 && nc < 5 && visit[nr][nc] && !nowVisit[nr][nc]) {
                    nowVisit[nr][nc] = true;
                    queue.add(new Info(nr, nc));
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(visit[i][j] != nowVisit[i][j]) return false;
            }
        }

        return true;
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}