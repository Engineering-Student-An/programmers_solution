import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dirRow = {0, 0, -1, 1};
    static int[] dirCol = {1, -1, 0, 0};
    static int[] result = new int[6];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Info now = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());

            now = command(now, d);
        }

        System.out.print(sb);
    }

    static Info command(Info now, int d) {

        int nr = now.r + dirRow[d - 1];
        int nc = now.c + dirCol[d - 1];

        if(nr >= 0 && nc >= 0 && nr < n && nc < m) {

            if(d == 1) {    // 우
                swap(1, 4, 3, 5);
            } else if(d == 2) { // 좌
                swap(1, 5, 3, 4);
            } else if(d == 3) { // 상
                swap(0, 1, 2, 3);
            } else {    // 하
                swap(0, 3, 2, 1);
            }

            if(arr[nr][nc] == 0) {
                arr[nr][nc] = result[3];
            } else {
                result[3] = arr[nr][nc];
                arr[nr][nc] = 0;
            }

            sb.append(result[1]).append("\n");

            return new Info(nr, nc);
        } else return now;
    }

    static void swap(int a, int b, int c, int d) {
        int temp = result[a];
        result[a] = result[b];
        result[b] = result[c];
        result[c] = result[d];
        result[d] = temp;
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}