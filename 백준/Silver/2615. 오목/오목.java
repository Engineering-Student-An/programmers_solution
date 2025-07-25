import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n = 19;
    static int[][] arr = new int[19][19];
    static int[] dirRow = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dirCol = {1, 1, 1, 0, -1, -1, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = {-1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dirRow[k + 4];
                        int nc = j + dirCol[k + 4];
                        if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                            if(arr[nr][nc] != arr[i][j]) result = check(i, j, k);
                        } else {
                            result = check(i, j, k);
                        }
                        if(result[0] != -1 && result[1] != -1) break;
                    }
                }
                if(result[0] != -1 && result[1] != -1) break;
            }
            if(result[0] != -1 && result[1] != -1) break;
        }

        if(result[0] == -1 && result[1] == -1) {
            System.out.println(0);
        } else {
            System.out.println(arr[result[0]][result[1]]);
            System.out.println((result[0] + 1) + " " + (result[1] + 1));
        }
    }

    static int[] check(int sr, int sc, int d) {
        int count = 1;
        int num = arr[sr][sc];

        for (int i = 1; i < 6; i++) {
            int nr = sr + i * dirRow[d];
            int nc = sc + i * dirCol[d];
            if(nr >= 0 && nc >= 0 && nr < n && nc < n ) {
                if(arr[nr][nc] == num) count ++;
                else break;
            }
        }

        if(count == 5) return new int[] {sr, sc};
        return new int[]{-1, -1};
    }
}