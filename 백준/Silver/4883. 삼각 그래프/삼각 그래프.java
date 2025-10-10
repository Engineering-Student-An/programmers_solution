import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int[] dirRow = {-1, -1, -1, 0};
        int[] dirCol = {-1, 0, 1, -1};

        int testCase = 1;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] result = new int[n][3];
            result[0][0] = Integer.MAX_VALUE;
            result[0][1] = arr[0][1];
            result[0][2] = result[0][1] + arr[0][2];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dirRow[k];
                        int nc = j + dirCol[k];

                        if (nc >= 0 && nr < n && nc < 3 && result[nr][nc] != Integer.MAX_VALUE) {
                            result[i][j] = Math.min(result[i][j], result[nr][nc] + arr[i][j]);
                        }
                    }
                }
            }

            sb.append(testCase ++).append(". ").append(result[n - 1][1]).append("\n");
        }

        System.out.print(sb);
    }
}