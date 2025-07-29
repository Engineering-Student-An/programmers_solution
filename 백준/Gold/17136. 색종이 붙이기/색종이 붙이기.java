import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr = new int[10][10];
    static int[] paper = {5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void dfs(int index, int used) {

        if(used >= result) return;

        if(index == 100) {
            result = Math.min(result, used);
            return;
        }

        int r = index / 10;
        int c = index % 10;

        if(arr[r][c] == 0) {
            dfs(index + 1, used);
            return;
        }

        for (int k = 4; k >= 0; k--) {
            if(paper[k] <= 0) continue;

            if(check(r, c, k)) {
                fix(true, r, c, k);
                dfs(index + 1, used + 1);
                fix(false, r, c, k);
            }
        }
    }

    static void fix(boolean isFix, int r, int c, int k) {
        paper[k] = (isFix) ? paper[k] - 1 : paper[k] + 1;

        for (int i = r; i <= r + k; i++) {
            for (int j = c; j <= c + k; j++) {
                arr[i][j] = (isFix) ? 0 : 1;
            }
        }
    }

    static boolean check(int r, int c, int k) {
        if(r + k >= 10 || c + k >= 10) return false;

        for (int i = r; i <= r + k; i++) {
            for (int j = c; j <= c + k; j++) {
                if(arr[i][j] == 0) return false;
            }
        }

        return true;
    }
}