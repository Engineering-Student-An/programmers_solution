import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        int startRow = 0, startCol = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if(c == 'X') arr[i][j] = 1;
                else if(c == 'P') arr[i][j] = 2;
                else if(c == 'I') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int ans = bfs(startRow, startCol);
        System.out.println(ans != 0 ? ans : "TT");
    }

    static int bfs(int r, int c) {
        int count = 0;
        int[] dirRow = {0, 1, 0, -1};
        int[] dirCol = {1, 0, -1, 0};

        arr[r][c] = 3;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if(arr[nr][nc] == 0 || arr[nr][nc] == 2){
                        if(arr[nr][nc] == 2) count ++;
                        arr[nr][nc] = 3;
                        queue.add(new Info(nr, nc));
                    }
                }
            }
        }

        return count;
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}