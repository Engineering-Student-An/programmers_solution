import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, t;
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1}, dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (line.charAt(j) == 'O') ? 3 : 0;
            }
        }

        for (int s = 2; s <= t; s++) {

            // 1초 지남
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] > 0) arr[i][j] --;
                }
            }

            // 3. 폭탄 없는 곳에 폭탄 설치
            if(s % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if(arr[i][j] == 0) arr[i][j] = 4;
                    }
                }
            }

            // 4. 3초 전 폭탄 폭발
            else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if(arr[i][j] == 1) {
                            arr[i][j] = 0;
                            for (int k = 0; k < 4; k++) {
                                int nr = i + dirRow[k];
                                int nc = j + dirCol[k];

                                if(nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] != 1) arr[nr][nc] = 0;
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append((arr[i][j] == 0) ? "." : "O");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}