import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int h = Integer.parseInt(st.nextToken());
            for (int j = n-1; j >= n - h; j--) {
                arr[j][i] = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int c = 0;
            int start = -1;
            while(c < m) {
                if(start == -1 && arr[i][c] == 1) {
                    start = c;
                } else if(start != -1 && arr[i][c] == 1) {
                    for (int j = start + 1; j < c; j++) {
                        arr[i][j] = 2;
                        count ++;
                    }
                    start = c;
                }
                c ++;
            }
        }

        System.out.println(count);
    }
}