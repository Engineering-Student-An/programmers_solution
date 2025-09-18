import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dirRow = {0, -1, 0, 1};
    static int[] dirCol = {-1, 0, 1, 0};
    static int[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxArea = Integer.MIN_VALUE;
        visit = new int[n][m];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visit[i][j] == 0) {
                    count ++;
                    int area = bfs(i, j, count);
                    maxArea = Math.max(maxArea, area);
                    map.put(count, area);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if( (arr[i][j] & (1 << k)) != 0) {
                        int nr = i + dirRow[k];
                        int nc = j + dirCol[k];

                        if(nr >= 0 && nc >= 0 && nr < n && nc < m && visit[i][j] != visit[nr][nc]) {
                            maxArea = Math.max(maxArea, map.get(visit[i][j]) + map.get(visit[nr][nc]));
                        }
                    }
                }
            }
        }

        System.out.println(maxArea);
    }

    static int bfs(int r, int c, int num) {
        int area = 1;
        visit[r][c] = num;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                // 벽이 존재하는 경우

                if((arr[now.r][now.c] & (1 << i)) != 0) continue;

                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && visit[nr][nc] == 0) {
                    visit[nr][nc] = num;
                    area ++;
                    queue.add(new Info(nr, nc));
                }
            }
        }

        return area;
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}