import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] adjacencyList = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        int[] result = new int[n+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(k);

        int count = 1;
        while (!stack.isEmpty()) {
            Integer now = stack.pop();
            if(result[now] == 0) result[now] = count ++;

            while(!adjacencyList[now].isEmpty()) {
                Integer next = adjacencyList[now].poll();

                if(result[next] == 0) {
                    stack.push(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.print(sb);
    }
}