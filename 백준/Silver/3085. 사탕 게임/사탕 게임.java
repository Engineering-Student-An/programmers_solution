import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, result = 0;
    static char[][] arr;
    static char[] list = {'C', 'P', 'Z', 'Y'};
    static int[] dirRow = {0, 1}, dirCol = {1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        boolean isMax = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    int nr = i + dirRow[k];
                    int nc = j + dirCol[k];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && arr[i][j] != arr[nr][nc]) {
                        swap(i, j, nr, nc);
                        result = Math.max(result, count());
                        swap(i, j, nr, nc);
                    }

                    if(result == n) {
                        isMax = true;
                        break;
                    }
                }
                if(isMax) break;
            }
            if(isMax) break;
        }

        System.out.println(result);
    }

    static int count() {
        int result = 0;

        // 행 카운트
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 4; k++) {
                char c = list[k];
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == c) {
                        count ++;
                    } else if(count > 0){
                        result = Math.max(result, count);
                        count = 0;
                    }
                }

                if(count > 0) {
                    result = Math.max(result, count);
                }
            }
        }

        // 열 카운트
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 4; k++) {
                char c = list[k];
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if(arr[j][i] == c) {
                        count ++;
                    } else if(count > 0){
                        result = Math.max(result, count);
                        count = 0;
                    }
                }

                if(count > 0) {
                    result = Math.max(result, count);
                }
            }
        }

        return result;
    }

    static void swap(int r1, int c1, int r2, int c2) {
        char temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
}