import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j]) {
                    visit[i][j] = true;
                    dfs(i, j, arr[i][j], 1);
                    visit[i][j] = false;
                    mountain(i, j);
                }
            }
        }

        System.out.println(max);
    }

    static void mountain(int r, int c) {

        if(r-1 >= 0 && c-1 >= 0 && r+1 < n) {// ㅓ
            int sum = arr[r][c] + arr[r-1][c] + arr[r+1][c] + arr[r][c-1];
            max = Math.max(max, sum);
        }
        if(c-1 >= 0 && r+1 < n && c+1 < m) { // ㅜ
            int sum = arr[r][c] + arr[r][c-1] + arr[r+1][c] + arr[r][c+1];
            max = Math.max(max, sum);
        }
        if(r-1 >= 0 && r+1 < n && c+1 < m) { // ㅏ
            int sum = arr[r][c] + arr[r-1][c] + arr[r+1][c] + arr[r][c+1];
            max = Math.max(max, sum);
        }
        if(r-1 >= 0 && c-1 >= 0 && c+1 < m) { // ㅗ
            int sum = arr[r][c] + arr[r-1][c] + arr[r][c-1] + arr[r][c+1];
            max = Math.max(max, sum);
        }
    }

    static void dfs(int r, int c, int sum, int count) {
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dirRow[i];
            int nextC = c + dirCol[i];

            if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && !visit[nextR][nextC]){
                visit[nextR][nextC] = true;
                dfs(nextR, nextC, sum + arr[nextR][nextC], count + 1);
                visit[nextR][nextC] = false;
            }
        }
    }
}