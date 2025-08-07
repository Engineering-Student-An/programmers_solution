import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] time, inDegree, result;
    static List<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        time = new int[n+1];
        inDegree = new int[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(st.nextToken());
                adjacencyList[v].add(i);
                inDegree[i] ++;
            }
        }

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();

        result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = (inDegree[i] > 0) ? Integer.MIN_VALUE : time[i];
            if(inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : adjacencyList[now]) {
                inDegree[next] --;
                if(inDegree[next] == 0) queue.add(next);

                if(result[next] < result[now] + time[next]) {
                    result[next] = result[now] + time[next];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n + 1; i++) {
            max = Math.max(max, result[i]);
        }
        System.out.println(max);
    }
}