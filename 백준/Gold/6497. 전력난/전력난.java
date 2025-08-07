import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] parent;
    static PriorityQueue<Info> edgeList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            edgeList = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
            int sum = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                sum += value;
                edgeList.add(new Info(u, v, value));
            }

            int count = 0;
            int cost = 0;
            while (count < n - 1 && !edgeList.isEmpty()) {
                Info now = edgeList.poll();

                if(find(now.s) != find(now.e)) {
                    union(now.s, now.e);
                    cost += now.v;
                    count ++;
                }
            }

            sb.append(sum - cost).append("\n");
        }
        System.out.print(sb);


    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[Math.max(a, b)] = Math.min(a, b);
    }

    static class Info {
        int s, e, v;

        public Info(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
}