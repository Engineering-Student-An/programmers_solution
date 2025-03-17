import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Info>[] adjacencyList;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while(true) {
                int end = Integer.parseInt(st.nextToken());
                if(end == -1) break;
                long value = Long.parseLong(st.nextToken());

                adjacencyList[start].add(new Info(end, value));
            }
        }

        long[] distance = new long[n+1];
        bfs(1, distance);

        long max = distance[1];
        int startIndex = 1;
        for (int i = 2; i <= n; i++) {
            if(max < distance[i]) {
                startIndex = i;
                max = distance[i];
            }
        }

        distance = new long[n+1];
        bfs(startIndex, distance);

        max = distance[1];
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, distance[i]);
        }

        System.out.println(max);
    }

    static void bfs(int num, long[] distance) {

        boolean[] visit = new boolean[n+1];
        visit[num] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(num, 0));

        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            for (Info info : adjacencyList[poll.node]) {
                if(!visit[info.node]) {
                    visit[info.node] = true;
                    distance[info.node] = distance[poll.node] + info.value;
                    queue.add(info);
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