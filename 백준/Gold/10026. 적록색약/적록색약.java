import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dir_row = {0, 1, 0, -1};
    static int[] dir_col = {1, 0, -1, 0};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        char[][] arr = new char[n][n];
        char[][] colorArr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
                colorArr[i][j] = (arr[i][j] == 'G') ? 'R' : arr[i][j];
            }
        }

        boolean[][] visit1 = new boolean[n][n];
        boolean[][] visit2 = new boolean[n][n];

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit1[i][j]) {
                    ++count1;
                    bfs(arr, n, i, j, visit1);
                }
                if(!visit2[i][j]) {
                    ++count2;
                    bfs(colorArr, n, i, j, visit2);
                }
            }
        }
        System.out.print(count1 + " " + count2);

    }

    private static void bfs(char[][] arr, int n, int i, int j, boolean[][] visit) {
        Queue<Index> queue = new LinkedList<>();

        queue.add(new Index(i, j));
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            Index index = queue.poll();

            for (int k = 0; k < 4; k++) {
                int next_row = index.row + dir_row[k];
                int next_col = index.col + dir_col[k];

                if(next_row >= 0 && next_row < n && next_col >= 0 && next_col < n
                        && arr[next_row][next_col] == arr[index.row][index.col]
                        && !visit[next_row][next_col]) {

                    visit[next_row][next_col] = true;
                    queue.add(new Index(next_row, next_col));
                }
            }
        }
    }

    static class Index {
        int row;
        int col;

        public Index(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}