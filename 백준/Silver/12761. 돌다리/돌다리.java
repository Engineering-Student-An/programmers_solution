import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, a, b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] visit = new int[100001];
        for (int i = 0; i < 100001; i++) visit[i] = Integer.MAX_VALUE;

        visit[n] = 0;
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        queue.add(new Info(n, 0));

        int[] move = {1, -1, a, -a, b, -b};
        int[] jump = {a, b};
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(now.node == m) {
                System.out.println(now.count);
                break;
            }

            if(visit[now.node] > now.count) continue;

            for (int i = 0; i < 6; i++) {
                int next = now.node + move[i];
                if(next >= 0 && next <= 100000 && visit[next] > now.count + 1) {
                    visit[next] = now.count + 1;
                    queue.add(new Info(next, visit[next]));
                }
            }

            for (int i = 0; i < 2; i++) {
                int next = now.node * jump[i];
                if(next >= 0 && next <= 100000 && visit[next] > now.count + 1) {
                    visit[next] = now.count + 1;
                    queue.add(new Info(next, visit[next]));
                }
            }
        }
    }

    static class Info {
        int node, count;

        public Info(int node, int count) {
            this.node = node;
            this.count = count;
        }
    }
}