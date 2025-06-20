import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

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

        for (int in = 0; in < Math.min(n, m) / 2; in++) {
            rotate(in);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void rotate(int in) {
        int r = in;
        int c = in;

        int nn = n - in;
        int mm = m - in;
        int cycle = (2 * (n - 2 * in)) + (2 * (m - 2 * in - 2));
        int rr = k % cycle;
        int[][] temp = new int[n][m];
        for (int t = 0; t < rr; t++) {
            int index = 0;

            while(index <= 3) {
                int nextR = r + dirRow[index];
                int nextC = c + dirCol[index];

                if(nextR >= in && nextC >= in && nextR < nn && nextC < mm) {
                    temp[r][c] = arr[nextR][nextC];
                    r = nextR;
                    c = nextC;
                } else {
                    index ++;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(temp[i][j] != 0) arr[i][j] = temp[i][j];
                }
            }
        }
    }
}