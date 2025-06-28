import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, count = 1;
    static char[][] arr;
//    static int[][] parents;
    static int[][] result;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        result = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j]) {
//                    visit[i][j] = true;
                    result[i][j] = dfs(i, j);
                }
            }
        }

        System.out.println(count - 1);
    }

    static int dfs(int r, int c) {

        int nr = r;
        int nc = c;
        if(arr[r][c] == 'D') {
            nr ++;
        } else if(arr[r][c] == 'R') {
            nc ++;
        } else if(arr[r][c] == 'L') {
            nc --;
        } else {
            nr --;
        }

        if(visit[nr][nc] && result[nr][nc] != 0) {
            return result[nr][nc];
        } else if(visit[nr][nc] && result[nr][nc] == 0) {
            return count ++;
        }

        visit[r][c] = true;
        return result[r][c] = dfs(nr, nc);
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}