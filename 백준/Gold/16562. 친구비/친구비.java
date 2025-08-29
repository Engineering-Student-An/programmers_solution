import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static List<Integer>[] adjacencyList;
    static int[] parent, money;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        money = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for(Integer next : adjacencyList[i]) {
                union(i, next);
            }
        }

        boolean[] visit = new boolean[n+1];
        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.add(new Info(parent[i], money[i]));
        }

        int result = 0;
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            if(!visit[find(now.p)]) {
                visit[now.p] = true;
                result += now.cost;
            }
        }

        System.out.println(result <= k ? result : "Oh no");
    }

    static class Info implements Comparable<Info> {
        int p, cost;

        @Override
        public int compareTo(Info o) {
            return (this.cost - o.cost);
        }

        public Info(int p, int cost) {
            this.p = p;
            this.cost = cost;
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[Math.max(a, b)] = Math.min(a, b);
        }
    }
}