import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, result = Integer.MAX_VALUE;
    static int[][] arr, rotate;
    static int[] seq;
    static int[] dirRow = {1, 0, -1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        seq = new int[k];
        rotate = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rotate[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < k; i++) {
            seq[0] = i;
            boolean[] visit = new boolean[k];
            visit[i] = true;
            find(1, visit);
        }

        System.out.println(result);

    }

    static void find(int index, boolean[] visit) {
        if(index == k) {

            int[][] temp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }


            for (int i = 0; i < k; i++) rotate(i, temp);

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += temp[i][j];
                }

                min = Math.min(min, sum);
            }

            result = Math.min(min, result);

            return;
        }

        for (int i = 0; i < k; i++) {
            if(!visit[i]) {
                visit[i] = true;
                seq[index] = i;
                find(index + 1, visit);
                visit[i] = false;
            }
        }
    }

    static void rotate(int index, int[][] temp) {

        int r = rotate[seq[index]][0];
        int c = rotate[seq[index]][1];
        int s = rotate[seq[index]][2];

        for (int i = 0; i < rotate[seq[index]][2]; i++) {
            int nr = r - s - 1;
            int nc = c - s - 1;
            int first = temp[nr][nc];

            int k = 0;
            while(true) {
                int nextRow = nr + dirRow[k];
                int nextCol = nc + dirCol[k];

                if (nextRow >= r - s - 1 && nextRow <= r + s - 1 && nextCol >= c - s - 1 && nextCol <= c + s - 1) {
                    temp[nr][nc] = temp[nextRow][nextCol];
                    nr = nextRow;
                    nc = nextCol;

                    if(nr == r-s-1 && nc == c-s) break;
                } else {
                    k ++;
                }

                if(k >= 4) break;
            }

            temp[r-s-1][c-s] = first;
            s --;
        }
    }
}