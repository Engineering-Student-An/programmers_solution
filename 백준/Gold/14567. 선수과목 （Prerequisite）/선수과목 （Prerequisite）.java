import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] adjacencyList;
    static int[] inDegree, result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        inDegree = new int[n+1];
        result = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            inDegree[v] ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(inDegree[i] > 0) result[i] = Integer.MIN_VALUE;
            else {
                result[i] = 1;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : adjacencyList[now]) {
                result[next] = Math.max(result[next], result[now] + 1);
                inDegree[next] --;

                if(inDegree[next] == 0) queue.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);

    }
}