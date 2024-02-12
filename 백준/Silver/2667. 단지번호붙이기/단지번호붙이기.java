import java.util.*;

public class Main {

    public static int[][] arr;
    public static int total;
    public static ArrayList<Integer> count = new ArrayList<>();
    public static int[] dir_i = {-1, 0, 1, 0};
    public static int[] dir_j = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (line.charAt(j) - '0');
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1){
                    count.add(bfs(n,i,j));
                }
            }
        }

        System.out.println(count.size());
        Collections.sort(count);
        for (int i : count) {
            System.out.println(i);
        }
    }

    private static int bfs(int n, int i, int j) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {i,j});
        int cnt = 1;
        arr[i][j] = 2;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int now_i = p[0];
            int now_j = p[1];

            for (int k = 0; k < 4; k++) {
                int next_i = now_i + dir_i[k];
                int next_j = now_j + dir_j[k];
                if(next_i >= 0 && next_i < n && next_j >= 0 && next_j < n && arr[next_i][next_j] == 1){
                    q.add(new int[]{next_i, next_j});
                    cnt++;
                    arr[next_i][next_j] = 2;
                }
            }
        }
        return cnt;
    }
}

