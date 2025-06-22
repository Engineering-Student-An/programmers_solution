import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Info>[] adjacencyList;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(new Info(v, value));
            adjacencyList[v].add(new Info(u, value));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        result = new int[n+1];

        dijkstra(start);

        System.out.println(result[end]);
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= n; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[start] = 0;

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));
        queue.add(new Info(start, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.node] < now.value) continue;

            for (Info next : adjacencyList[now.node]) {
                if(result[next.node] > result[now.node] + next.value) {
                    result[next.node] = result[now.node] + next.value;
                    queue.add(new Info(next.node, result[next.node]));
                }
            }
        }
    }

    static class Info {
        int node, value;

        public Info(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}