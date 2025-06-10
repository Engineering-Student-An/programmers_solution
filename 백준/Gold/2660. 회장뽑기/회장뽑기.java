import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] result = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            result[i][i] = 0;
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(u == -1 && v == -1) break;

            result[u][v] = 1;
            result[v][u] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if(result[s][k] != Integer.MAX_VALUE && result[k][e] != Integer.MAX_VALUE
                            && result[s][e] > result[s][k] + result[k][e]) {
                        result[s][e] = result[s][k] + result[k][e];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            int now = 0;
            for (int j = 1; j <= n; j++) {
                now = Math.max(now, result[i][j]);
            }

            if(min > now) {
                min = now;
                queue = new PriorityQueue<>();
                queue.add(i);
            } else if(min == now) {
                queue.add(i);
            }
        }

        System.out.println(min + " " + queue.size());
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}