import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] arr;
    static Info end;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static PriorityQueue<Info> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        queue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.count == o2.count) {
                    return o1.type - o2.type;
                }
                return o1.count - o2.count;
            }
        });

        Info start = null;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'S') {
                    start = new Info(i, j, 1, 0);
                    queue.add(start);
                    arr[i][j] = '.';
                } else if(arr[i][j] == 'D') {
                    end = new Info(i, j, 2, 0);
                }
                else if(arr[i][j] == '*') queue.add(new Info(i, j, 0, 0));
            }
        }

        int result = bfs(start);
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    static int bfs(Info start) {
        boolean[][] visit = new boolean[n][m];
        visit[start.r][start.c] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (now.type == 0 && arr[nr][nc] == '.') { // 물 움직임
                        queue.add(new Info(nr, nc, 0, now.count + 1));
                        arr[nr][nc] = '*';
                    } else if (now.type == 1 && !visit[nr][nc]) {    // 고슴도치 움직임
                        if (arr[nr][nc] == '.') {
                            queue.add(new Info(nr, nc, 1, now.count + 1));
                            visit[nr][nc] = true;
                        } else if (arr[nr][nc] == 'D') {
                            return now.count + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }

    static class Info {
        int r, c, type, count;  // type: 0 -> 물, 1 -> 고슴도치

        public Info(int r, int c, int type, int count) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.count = count;
        }
    }
}
