import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                long p = Long.parseLong(st.nextToken());
                if(j > i) {
                    queue.add(new Info(i, j, p));
                }
            }
        }

        int edgeCount = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        long sum = 0;
        while(edgeCount < n - 1) {
            Info now = queue.poll();

            if(find(now.a) != find(now.b)) {
                union(now.a, now.b);
                edgeCount ++;
                sum += now.cost;
            }
        }

        System.out.println(sum);
    }

    static int find(int a) {
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[Math.max(a, b)] = Math.min(a, b);
    }

    static class Info {
        int a, b;
        long cost;

        public Info(int a, int b, long cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}