import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tt = 0; tt < t; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adjacencyList = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adjacencyList[u].add(v);
                adjacencyList[v].add(u);
            }

            sb.append(bfs(1)).append("\n");

        }
        System.out.print(sb);
    }

    static int bfs(int num) {
        int count = 0;

        boolean[] visit = new boolean[n + 1];
        visit[1] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for(Integer next : adjacencyList[now]) {
                if(!visit[next]) {
                    queue.add(next);
                    count ++;
                    visit[next] = true;
                }
            }
        }

        return count;
    }
}