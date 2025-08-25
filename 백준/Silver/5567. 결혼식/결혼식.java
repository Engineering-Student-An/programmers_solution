import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        int[] distance = new int[n+1];
        for (int i = 2; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if(distance[now] > 2) continue;

            for (Integer next : adjacencyList[now]) {
                if(distance[next] > distance[now] + 1) {
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if(distance[i] < 3) count ++;
        }

        System.out.println(count);
    }
}