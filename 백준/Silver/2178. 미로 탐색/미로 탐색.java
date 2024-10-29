import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[n+2][m+2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = (line.charAt(j - 1) == '1');
            }
        }

        int[][] check = new int[n+1][m+1];
        Queue<int[]> queue = new LinkedList<>();

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        queue.add(new int[]{1, 1, 1});
        check[1][1] = 1;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            int r = poll[0];
            int c = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = r+dr[i];
                int nextCol = c+dc[i];
                if(arr[nextRow][nextCol] && check[nextRow][nextCol] == 0) {
                    queue.add(new int[]{nextRow, nextCol, poll[2]+1});
                    check[nextRow][nextCol] = poll[2]+1;
                }
            }
        }

        System.out.println(check[n][m]);
    }
}