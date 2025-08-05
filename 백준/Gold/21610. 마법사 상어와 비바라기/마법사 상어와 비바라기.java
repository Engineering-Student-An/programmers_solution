import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] cloud;
    static int[] dirRow = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dirCol = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        cloud = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구름 상태
        cloud[n-2][0] = true;
        cloud[n-2][1] = true;
        cloud[n-1][0] = true;
        cloud[n-1][1] = true;

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());

            // 1. 구름 이동
            boolean[][] temp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(cloud[i][j]) cloudMove(i, j, d - 1, move, temp);
                }
            }

            // 2. 비내림
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(temp[i][j]) arr[i][j] ++;
                }
            }

            // 3. 물복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(temp[i][j]) copyWater(i, j);
                }
            }

            // 4. 새 구름 생성
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cloud[i][j] = false;
                    if(arr[i][j] >= 2 && !temp[i][j]) {
                        cloud[i][j] = true;
                        arr[i][j] -= 2;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += arr[i][j];
            }
        }

        System.out.println(result);
    }

    static void cloudMove(int r, int c, int d, int move, boolean[][] temp) {
        int nr = (r + n + (dirRow[d] * move) % n) % n;
        int nc = (c + n + (dirCol[d] * move) % n) % n;

        temp[nr][nc] = true;
    }

    static void copyWater(int r, int c) {
        for (int k = 1; k < 8; k+=2) {
            int nr = r + dirRow[k];
            int nc = c + dirCol[k];

            if(nr >= 0 && nr < n && nc >= 0 && nc < n && arr[nr][nc] > 0) arr[r][c] ++;
        }
    }
}