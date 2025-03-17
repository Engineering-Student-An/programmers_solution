import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static PriorityQueue<Integer>[] adjacencyList1;
    static PriorityQueue<Integer>[] adjacencyList2;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        adjacencyList1 = new PriorityQueue[n+1];
        adjacencyList2 = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList1[i] = new PriorityQueue<>();
            adjacencyList2[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjacencyList1[start].add(end);
            adjacencyList2[start].add(end);
            adjacencyList1[end].add(start);
            adjacencyList2[end].add(start);
        }

        sb = new StringBuilder();
        visit = new boolean[n + 1];
        dfs(v);

        sb.append("\n");
        visit = new boolean[n + 1];
        bfs(v);

        System.out.print(sb);
    }

    static void dfs(int node) {

        visit[node] = true;
        sb.append(node).append(" ");
        while(!adjacencyList1[node].isEmpty()) {
            Integer integer = adjacencyList1[node].poll();
            if(!visit[integer]) {
                dfs(integer);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visit[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
            while (!adjacencyList2[poll].isEmpty()) {
                Integer integer = adjacencyList2[poll].poll();

                if(!visit[integer]) {
                    visit[integer] = true;
                    queue.add(integer);
                }
            }
        }
    }
}