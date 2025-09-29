import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        find(0, 0);

        System.out.println(result);
    }

    static void find(int s, int sum) {

        if(s == n * m) {
            result = Math.max(result, sum);
            return;
        }

        int r = s / m;
        int c = s - (r * m);

        if(visit[r][c]) {
            find(s + 1, sum);
        } else {

            // 한 칸
            visit[r][c] = true;
            find(s + 1, sum + arr[r][c]);

            // 가로
            int num = arr[r][c];

            int i = 0;
            for (i = 1; c + i < m; i++) {
                if(!visit[r][c + i]) {
                    visit[r][c + i] = true;
                    num = num * 10 + arr[r][c + i];
//                    System.out.println("(" + r + ", " + c + ") => (" + r + ", " + (c + i) + ")");
                    find(s + 1, sum + num);
                } else break;
            }
            for (int j = 1; j < i; j++) {
                visit[r][c + j] = false;
            }

            // 세로
            num = arr[r][c];
            for (i = 1; r + i < n; i++) {
                if(!visit[r + i][c]) {
                    visit[r + i][c] = true;
                    num = num * 10 + arr[r + i][c];
//                    System.out.println("(" + r + ", " + c + ") => (" + (r + i) + ", " + c + ")");
                    find(s + 1, sum + num);
                } else break;
            }
            for (int j = 1; j < i; j++) {
                visit[r + j][c] = false;
            }

            visit[r][c] = false;
        }
    }
}