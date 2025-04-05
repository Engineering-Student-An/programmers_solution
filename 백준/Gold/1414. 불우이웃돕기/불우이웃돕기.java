import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int[][] arr;
    static PriorityQueue<Edge> edges = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int all = 0;
        arr = new int[n][n];
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                if(c == '0') continue;
                if(c >= 'a' && c <= 'z') {
                    arr[i][j] = c - 'a' + 1;
                } else {
                    arr[i][j] = c - 'A' + 27;
                }
                all += arr[i][j];

                if(i != j) {
                    edges.add(new Edge(i, j, arr[i][j]));
                }
            }
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 0;
        int sum = 0;
        while(!edges.isEmpty()  && count < n-1) {
            Edge edge = edges.poll();

            if(find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                count ++;
                sum += edge.v;
            }
        }

        if(count < n-1) System.out.println(-1);
        else System.out.println(all-sum);
    }

    static int find(int a) {
        if(a == parent[a]) return a;

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
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
}