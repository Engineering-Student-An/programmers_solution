import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static int[] dir_i = {-1, 0, 1, 0};
    public static int[] dir_j = {0, 1, 0, -1};
    public static boolean[][] visit;
    
    
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1){
                    queue.add(new int[]{i, j});
//                    visit[i][j] = true;
                }
            }
        }

        bfs(n, m, queue);
        boolean fail = false;
        int full = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    fail = true;
                    break;
                }
                if(arr[i][j]!=-1 && full < arr[i][j]) {
                    full = arr[i][j];
                }
            }
            if(fail) break;
        }
        if(fail) {
            System.out.println(-1);
        } else {
            System.out.println(full-1);
        }

    }

    private static void bfs(int n, int m, Queue<int[]> queue) {
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int now_i = temp[0];
            int now_j = temp[1];
            for (int i = 0; i < 4; i++) {
                int next_i = now_i + dir_i[i];
                int next_j = now_j + dir_j[i];
                if(next_i >= 0 && next_i < n && next_j >= 0 && next_j < m && arr[next_i][next_j] == 0){
                    queue.add(new int[]{next_i, next_j});
//                    visit[next_i][next_j] = true;
                    arr[next_i][next_j] = arr[now_i][now_j] + 1;
                }
            }
        }        
    }
}

