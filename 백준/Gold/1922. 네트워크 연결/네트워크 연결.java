import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static PriorityQueue<Edge> edges = new PriorityQueue<>((o1, o2) -> Long.compare(o1.v, o2.v));
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long v = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, e, v));
        }

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int count = 0;
        long sum = 0;
        while (count < n - 1) {
            Edge edge = edges.poll();

            if(find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                count ++;
                sum += edge.v;
            }
        }

        System.out.println(sum);
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }

    static class Edge {
        int s;
        int e;
        long v;

        public Edge(int s, int e, long v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
}