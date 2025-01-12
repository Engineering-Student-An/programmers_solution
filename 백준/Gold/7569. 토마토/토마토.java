import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int n;
    static int h;
    static int[][][] arr;
    static boolean[][][] visit;
    static int[][][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][n][m];
        result = new int[h][n][m];
        visit = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<Info> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(arr[i][j][k] == 1) {
                        queue.add(new Info(i, j, k, 0));
                        visit[i][j][k] = true;
                    }
                }
            }
        }

        List<Info> nextDir = List.of(new Info(1, 0, 0, 0), new Info(-1, 0, 0, 0),
                new Info(0, 1, 0, 0), new Info(0, -1, 0, 0), new Info(0, 0, 1, 0), new Info(0, 0, -1, 0));

        long max = -9999;
        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            result[poll.h][poll.n][poll.m] = poll.count;
            arr[poll.h][poll.n][poll.m] = 1;

            if(max < poll.count) {
                max = poll.count;
            }

            for (Info next : nextDir) {
                int nextH = poll.h + next.h;
                int nextN = poll.n + next.n;
                int nextM = poll.m + next.m;
                if(nextH >= 0 && nextH < h && nextN >= 0 && nextN < n && nextM >= 0 && nextM < m &&
                        arr[nextH][nextN][nextM] == 0 && !visit[nextH][nextN][nextM]) {
                    queue.add(new Info(nextH, nextN, nextM, poll.count + 1));
                    visit[nextH][nextN][nextM] = true;
                }
            }
        }

        boolean isPossible = true;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(arr[i][j][k] == 0) {
                        isPossible = false;
                        break;
                    }
                }

                if(!isPossible) break;
            }
            if(!isPossible) break;
        }

        System.out.print(isPossible ? max : -1);
    }

    static class Info {
        int h;
        int n;
        int m;
        int count;

        public Info(int h, int n, int m, int count) {
            this.h = h;
            this.n = n;
            this.m = m;
            this.count = count;
        }
    }
}