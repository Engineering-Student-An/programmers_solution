import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        ArrayList<Info> infos = new ArrayList<>();

        for (int i = 0; i < n*m; i++) {
            if(arr[i/m][i%m] != 0) continue;
            for (int j = i+1; j < n*m; j++) {
                if(arr[j/m][j%m] != 0) continue;
                for (int k = j+1; k < n*m; k++) {
                    if(arr[k/m][k%m] != 0) continue;

                    infos.add(new Info(i,j,k));
                }
            }
        }

        int max = -1;
        int count = 0;

        for (Info info : infos) {

            int[][] temp = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(arr[i], 0, temp[i], 0, m);
            }


            temp[info.first/m][info.first%m] = 1;
            temp[info.second/m][info.second%m] = 1;
            temp[info.third/m][info.third%m] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(temp[i][j] == 2) bfs(temp, i, j);
                }
            }

            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(temp[i][j] == 0) count ++;
                }
            }


            if(count > max) max = count;
        }
        System.out.println(max);
    }

    private static void bfs(int[][] arr, int i, int j) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i,j));

        arr[i][j] = 3;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextRow = poll.row + dirRow[k];
                int nextCol = poll.col + dirCol[k];

                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m
                        && arr[nextRow][nextCol] == 0) {
                    arr[nextRow][nextCol] = 3;
                    queue.add(new Node(nextRow, nextCol));
                }
            }
        }
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Info {
        int first;
        int second;
        int third;

        public Info(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}