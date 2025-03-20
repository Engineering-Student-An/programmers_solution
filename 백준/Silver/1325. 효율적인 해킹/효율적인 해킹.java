import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visit;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
        }

        int max = -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            int result = bfs(i);
            if(max == result) {
                queue.add(i);
            } else if(max < result) {
                queue = new PriorityQueue<>();
                queue.add(i);
                max = result;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
        }

        System.out.print(sb);
    }

    static int bfs(int start) {

        visit = new boolean[n+1];
        visit[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer i : adjacencyList[poll]) {
                if(!visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(visit[i]) {
                count++;
            }
        }

        return count;
    }
}