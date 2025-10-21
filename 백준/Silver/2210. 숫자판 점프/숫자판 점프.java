import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n = 5;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};
    static int[][] arr = new int[n][n];
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                find(i, j, String.valueOf(arr[i][j]), 1);
            }
        }

        System.out.println(set.size());
    }

    static void find(int r, int c, String num, int count) {
        if(count == 6) {
            set.add(num);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dirRow[i];
            int nc = c + dirCol[i];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                find(nr, nc, num + arr[nr][nc], count + 1);
            }
        }
    }
}