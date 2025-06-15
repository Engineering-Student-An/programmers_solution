import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int n;
    static int[] arr;
    static int[] result;
    static boolean[] visit;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        boolean[] contain = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            contain[arr[i]] = true;
        }

        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = (contain[i] && i != arr[i]) ? bfs(i, false) : Integer.MIN_VALUE;
            if(i == arr[i]) pq.add(i);
        }

        visit = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (result[i] != Integer.MIN_VALUE && !visit[i]) {
                bfs(i, true);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int s, boolean isResult) {

        if(!isResult) {
            boolean[][] visit = new boolean[2][n+1];
            visit[0][s] = true;
            visit[1][arr[s]] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(arr[s]);
            while (!queue.isEmpty()) {
                Integer now = queue.poll();

                if (!visit[0][now]) {
                    visit[0][now] = true;
                    visit[1][arr[now]] = true;
                    queue.add(arr[now]);
                }
            }

            boolean possible = true;
            int count = 0;
            for (int i = 1; i < n+1; i++) {
                if(visit[0][i] && !visit[1][i]) {
                    possible = false;
                    break;
                } else if(visit[0][i] && visit[1][i]){
                    count ++;
                }
            }

            return (!possible) ? Integer.MIN_VALUE : count;
        }
        else {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(arr[s]);
            visit[s] = true;
            while (!queue.isEmpty()) {
                Integer now = queue.poll();
                pq.add(now);
                if (!visit[now]) {
                    visit[now] = true;
                    queue.add(arr[now]);
                }
            }

            return 0;
        }
    }
}