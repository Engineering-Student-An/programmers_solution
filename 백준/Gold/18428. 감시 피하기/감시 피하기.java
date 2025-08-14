import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                char c = st.nextToken().charAt(0);
                if(c == 'S') arr[i][j] = 1;
                else if(c == 'T') arr[i][j] = 2;
            }
        }

        boolean isFound = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 3;
                    isFound = pick(i, j, 1);
                    arr[i][j] = 0;
                }
                if(isFound) {
                    break;
                }
            }
            if(isFound) break;
        }

        System.out.println((isFound) ? "YES" : "NO");
    }

    static boolean pick(int r, int c, int count) {
        if(count == 3) return check();

        // 같은 행
        for (int i = r; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == r && j <= c) continue;

                if(arr[i][j] == 0) {
                    arr[i][j] = 3;
                    if(pick(i, j, count + 1)) return true;
                    arr[i][j] = 0;
                }
            }
        }

        return false;
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i;
                        int nc = j;
                        while(true) {
                            nr += dirRow[k];
                            nc += dirCol[k];

                            if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                if (arr[nr][nc] == 3) break;
                                else if (arr[nr][nc] == 1) return false;
                            } else break;
                        }
                    }
                }
            }
        }

        return true;
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}