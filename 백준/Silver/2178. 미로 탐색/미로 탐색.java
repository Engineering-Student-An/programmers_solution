import java.util.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dir_x = {1, 0, -1, 0};
    static int[] dir_y = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int [n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (int) (line.charAt(j) - '0');
            }
        }

        visit[0][0] = true;
        bfs(0,0);
        System.out.println(arr[n-1][m-1]);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int now_y = temp[0];
            int now_x = temp[1];

            for (int i = 0; i < 4; i++) {
                int next_y = now_y + dir_y[i];
                int next_x = now_x + dir_x[i];
                if(next_y >= 0 && next_y < n && next_x >= 0 && next_x < m && arr[next_y][next_x] != 0
                        && !visit[next_y][next_x]){
                    queue.add(new int[]{next_y, next_x});
                    arr[next_y][next_x] = arr[now_y][now_x] + 1;
                    visit[next_y][next_x] = true;
                }
            }

        }
    }
}

