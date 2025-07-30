import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] arr, area;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        area = new int[n][m];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0 && area[i][j] == 0) bfs(i, j, num ++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0) sb.append(0);
                else {
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dirRow[k];
                        int nc = j + dirCol[k];

                        if(nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == 0) {
                            set.add(area[nr][nc]);
                        }
                    }

                    int count = 1;
                    for(Integer a : set) {
                        count = (count + (map.get(a) % 10)) % 10;
                    }
                    sb.append(count % 10);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int r, int c, int num) {

        int count = 0;
        area[r][c] = num;

        List<Info> list = new ArrayList<>();

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));

        while (!queue.isEmpty()) {
            count ++;
            Info now = queue.poll();
            list.add(now);

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == 0 && area[nr][nc] == 0) {
                    queue.add(new Info(nr, nc));
                    area[nr][nc] = num;
                }
            }
        }

        map.put(num, count);
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}