import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Info>[] adjacencyList;
    static List<Info>[] reverseAdjacencyList;
    static long[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        reverseAdjacencyList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            reverseAdjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            adjacencyList[s].add(new Info(e, value));
            reverseAdjacencyList[e].add(new Info(s, value));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        result = new long[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = Long.MAX_VALUE;
        }
        result[start] = 0;

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        sb.append(result[end]).append("\n");

        int index = end;
        int count = 1;
        List<Integer> route = new ArrayList<>();
        route.add(index);
        while(index != start) {
            for (Info info : reverseAdjacencyList[index]) {
                if(result[info.node] == result[index] - info.value) {
                    route.add(info.node);
                    index = info.node;
                    count ++;
                    break;
                }
            }
        }

        sb.append(count).append("\n");
        for (int i = route.size() - 1; i >= 0; i--) {
            sb.append(route.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.value, o2.value));
        queue.add(new Info(start, result[start]));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.node] < now.value) continue;

            for (Info next : adjacencyList[now.node]) {
                if(result[now.node] != Long.MAX_VALUE && result[next.node] > result[now.node] + next.value) {
                    result[next.node] = result[now.node] + next.value;
                    queue.add(new Info(next.node, result[next.node]));
                }
            }
        }
    }

    static class Info {
        int node;
        long value;

        public Info(int node, long value) {
            this.node = node;
            this.value = value;
        }
    }
}