import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] dirRow = {-1, -1, 0, 1, 1, 1, 0, -1}, dirCol = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == '*') sb.append("*");
                    else sb.append(find(i, j, arr));
                }

                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    static int find(int i, int j, char[][] arr) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int nr = i + dirRow[k];
            int nc = j + dirCol[k];

            if(nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == '*') count ++;
        }

        return count;
    }
}