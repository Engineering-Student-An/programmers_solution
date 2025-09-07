import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Node[] nodes;
    static Edge[] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int edgeCount = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(find(u) != find(v)) {
                union(u, v);
                edgeCount++;
            }
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o1.distance, o2.distance));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                double distance = Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2);
                queue.add(new Edge(i, j, distance));

            }
        }

        double result = 0.0;
        while(!queue.isEmpty() && edgeCount < n - 1) {
            Edge edge = queue.poll();

            if(find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                result += Math.sqrt(edge.distance);
                edgeCount ++;
            }
        }

        System.out.printf("%.2f%n", result);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[Math.max(a, b)] = Math.min(a, b);
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static class Edge {
        int u, v;
        double distance;

        public Edge(int u, int v, double distance) {
            this.u = u;
            this.v = v;
            this.distance = distance;
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}