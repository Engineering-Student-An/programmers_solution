import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int[][] arr, result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        result[0][0] = 0;

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));
        queue.add(new Info(0, 0, 0));

        int[] dirI = {0, 1, 0, -1};
        int[] dirJ = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.i][now.j] < now.value) continue;

            for (int i = 0; i < 4; i++) {
                int nextI = now.i + dirI[i];
                int nextJ = now.j + dirJ[i];

                if (nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < n) {
                    if(arr[nextI][nextJ] == 0 && result[nextI][nextJ] > result[now.i][now.j] + 1) {
                        result[nextI][nextJ] = result[now.i][now.j] + 1;
                        queue.add(new Info(nextI, nextJ, result[nextI][nextJ]));
                    } else if(arr[nextI][nextJ] == 1 && result[nextI][nextJ] > result[now.i][now.j]){
                        result[nextI][nextJ] = result[now.i][now.j];
                        queue.add(new Info(nextI, nextJ, result[nextI][nextJ]));
                    }
                }
            }
        }
        System.out.println(result[n-1][n-1]);
    }

    static class Info {
        int i, j, value;

        public Info(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}