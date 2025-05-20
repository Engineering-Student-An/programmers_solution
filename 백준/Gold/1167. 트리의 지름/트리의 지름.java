import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Info>[] adjacencyList;
    static long[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            adjacencyList[index] = new ArrayList<>();
            while(true) {
                int u = Integer.parseInt(st.nextToken());
                if(u == -1) break;
                long value = Long.parseLong(st.nextToken());

                adjacencyList[index].add(new Info(u, value));
            }
        }

        result = new long[n+1];
        bfs(1);

        long max = -1;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if(max < result[i]) {
                index = i;
                max = result[i];
            }
        }

        result = new long[n+1];
        bfs(index);

        max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }

        System.out.println(max);
    }

    static void bfs(int start) {

        boolean[] visit = new boolean[n+1];
        visit[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Info info : adjacencyList[now]) {
                int next = info.u;
                if(!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                    result[next] = result[now] + info.value;
                }
            }
        }
    }

    static class Info {
        int u;
        long value;

        public Info(int u, long value) {
            this.u = u;
            this.value = value;
        }
    }
}