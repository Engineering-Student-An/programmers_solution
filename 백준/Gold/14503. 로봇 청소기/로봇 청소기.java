import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(clean(row, col, dir));

    }

    static int clean(int row, int col, int dir) {
        int[] dirRow = {-1, 0, 1, 0};
        int[] dirCol = {0, 1, 0, -1};

        int count = 0;
        while(true) {
            if(arr[row][col] == 0) {
                count ++;
                arr[row][col] = 2;
            }
            boolean check = false;
            for (int i = 1; i <= 4; i++) {
                int nextDir = (dir - i + 4) % 4;
                int nextRow = row + dirRow[nextDir];
                int nextCol = col + dirCol[nextDir];
                if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] == 0) {
                    check = true;
                    row = nextRow;
                    col = nextCol;
                    dir = nextDir;
                    break;
                }
            }
            if(!check) {
                row = row + dirRow[(dir + 2) % 4];
                col = col + dirCol[(dir + 2) % 4];
                if(row < 0 || col < 0 || row >= n || col >= m || arr[row][col] == 1) break;
            }
        }

        return count;
    }
}