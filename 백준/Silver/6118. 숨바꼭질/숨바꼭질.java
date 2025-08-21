import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] adjacencyList;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i < n + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        result = new int[n+1];
        bfs();

        int num = 1, distance = Integer.MIN_VALUE, count = 0;
        for (int i = 2; i <= n; i++) {
            if(result[i] > distance) {
                num = i;
                count = 1;
                distance = result[i];
            } else if(result[i] == distance) {
                count ++;
            }
        }

        System.out.println(num + " " + distance + " " + count);
    }

    static void bfs() {
        for (int i = 2; i < n+1; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.distance, o2.distance));
        queue.add(new Info(1, result[1]));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.num] < now.distance) continue;

            for (Integer next : adjacencyList[now.num]) {
                if(result[next] > result[now.num] + 1) {
                    result[next] = result[now.num] + 1;
                    queue.add(new Info(next, result[next]));
                }
            }
        }
    }

    static class Info {
        int num, distance;

        public Info(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }
}