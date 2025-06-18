import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static char[][] arr;
    static boolean[][] visit;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        while(true) {
            visit = new boolean[12][6];
            boolean isBomb = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(!visit[i][j] && arr[i][j] != '.') {
                        if(bomb(i, j)) isBomb = true;
                    }
                }
            }

            if(!isBomb) break;

            count ++;

            fall();
        }

        System.out.println(count);
    }

    static void fall() {
        for (int j = 0; j < 6; j++) {
            int f = 0;
            for (int i = 11; i >= 0; i--) {
                if(arr[i][j] == '.') f ++;
                else {
                    arr[i+f][j] = arr[i][j];
                    if(f > 0) arr[i][j] = '.';
                }
            }
        }
    }

    static boolean bomb(int r, int c) {
        List<Info> list = new ArrayList<>();
        visit[r][c] = true;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));

        char ch = arr[r][c];

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            list.add(now);
            for (int i = 0; i < 4; i++) {
                int nextRow = now.r + dirRow[i];
                int nextCol = now.c + dirCol[i];

                if(nextRow >= 0 && nextCol >= 0 && nextRow < 12 && nextCol < 6
                        && arr[nextRow][nextCol] == ch && !visit[nextRow][nextCol]) {
                    visit[nextRow][nextCol] = true;
                    Info info = new Info(nextRow, nextCol);
                    queue.add(info);
                }
            }
        }

        if(list.size() < 4) return false;

        for(Info info : list) {
            arr[info.r][info.c] = '.';
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