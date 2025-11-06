import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        int k = Integer.parseInt(br.readLine());

        if(k > n * m) System.out.println(0);
        else {
            int r = n - 1, c = 0;
            int[] dirRow = {-1, 0, 1, 0}, dirCol = {0, 1, 0, -1};

            int dir = 0;
            int count = 1;
            while(count < k) {
                arr[r][c] = count;
                count ++;

                int nr = r + dirRow[dir], nc = c + dirCol[dir];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] != 0) {
                    dir = (dir + 1) % 4;
                    nr = r + dirRow[dir];
                    nc = c + dirCol[dir];
                }

                r = nr;
                c = nc;
            }

            System.out.println((c + 1) + " " + (n - r));
        }
    }
}