import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static int nowRow;
    static int nowCol;
    static boolean[][] visit;

    static int result = 0;
    static int foodCount = 0;
    static int size = 2;

    static int[] dRow = {-1, 0, 0, 1};
    static int[] dCol = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 9) {
                    nowRow = i;
                    nowCol = j;
                    arr[i][j] = 0;
                }
            }
        }

        while(true) {
            if (foodCount == size) {
                foodCount = 0;
                size++;
            }

            Info info = findFood(nowRow, nowCol);
            if (info == null) break;

            result += info.value;
            arr[info.row][info.col] = 0;
            foodCount ++;
            nowRow = info.row;
            nowCol = info.col;
        }

        System.out.println(result);
    }
    static Info findFood(int row, int col) {

        visit = new boolean[n][n];

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(row, col, 0));
        visit[row][col] = true;

        Info result = new Info(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        int distance = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Info poll = queue.poll();

            if(distance < poll.value) break;

            if(arr[poll.row][poll.col] > 0 && arr[poll.row][poll.col] < size) {

                if(poll.row < result.row) {
                    result = poll;
                } else if(poll.row == result.row && poll.col < result.col) {
                    result = poll;
                }
                distance = poll.value;
            }


            for (int i = 0; i < 4; i++) {
                int nextRow = poll.row + dRow[i];
                int nextCol = poll.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n || arr[nextRow][nextCol] > size) continue;

                if(!visit[nextRow][nextCol]) {
                    queue.add(new Info(nextRow, nextCol, poll.value + 1));
                    visit[nextRow][nextCol] = true;
                }
            }
        }
        if(result.value == Integer.MAX_VALUE) return null;
        return result;
    }

    static class Info {
        int row;
        int col;
        int value;

        public Info(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}