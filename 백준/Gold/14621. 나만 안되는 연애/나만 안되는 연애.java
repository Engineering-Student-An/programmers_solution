import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[] univ;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        univ = new char[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            univ[i] = st.nextToken().charAt(0);
        }

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            queue.add(new Info(s, e, v));
        }


        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int count = 0, sum = 0;
        while (!queue.isEmpty()) {

            Info now = queue.poll();
            if(univ[now.s] == univ[now.e]) continue;

            if(find(now.s) != find(now.e)) {
                union(now.s, now.e);
                count ++;
                sum += now.v;
            }

            if(count == n - 1) break;
        }

        System.out.println(count == n - 1 ? sum : -1);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[Math.max(a, b)] = Math.min(a, b);
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
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