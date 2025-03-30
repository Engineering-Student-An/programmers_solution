import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, d;
    static ArrayList<Info>[] adjacencyList;
    static long[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[d+1];
        for (int i = 0; i <= d; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            if(value < e-s && e <= d) adjacencyList[s].add(new Info(e, value));
        }

        dijkstra();

        System.out.println(result[d]);
    }

    static void dijkstra() {
        result = new long[d+1];
        for (int i = 1; i <= d; i++) {
            result[i] = Long.MAX_VALUE;
        }

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.value, o2.value));
        queue.add(new Info(0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.e] < now.value) continue;

            for (Info info : adjacencyList[now.e]) {
                if(info.e <= d && result[now.e] != Long.MAX_VALUE && result[info.e] > result[now.e] + info.value) {
                    result[info.e] = result[now.e] + info.value;
                    queue.add(new Info(info.e, result[info.e]));
                }
            }

            if(now.e < d && result[now.e] != Long.MAX_VALUE && result[now.e + 1] > result[now.e] + 1) {
                result[now.e + 1] = result[now.e] + 1;
                queue.add(new Info(now.e + 1, result[now.e + 1]));
            }
        }
    }

    static class Info {
        int e;
        long value;

        public Info(int e, long value) {
            this.e = e;
            this.value = value;
        }
    }
}