import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> climbQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.c, o2.c));
        PriorityQueue<Info> downQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.c, o1.c));

        long climb = 0;
        for (int i = 0; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(i == 0) {
                climb = (c == 0) ? climb + 1 : climb;
            } else {
                Info info = new Info(u, v, c);
                climbQueue.add(info);
                downQueue.add(info);
            }
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int count = 0;
        long max = climb, min = climb;
        while (!climbQueue.isEmpty() && count < n - 1) {
            Info now = climbQueue.poll();
            if(find(now.s) != find(now.e)) {
                count ++;
                union(now.s, now.e);
                if(now.c == 0) max ++;
            }
        }

        for (int i = 1; i <= n; i++) parent[i] = i;
        count = 0;
        while (!downQueue.isEmpty() && count < n - 1) {
            Info now = downQueue.poll();
            if(find(now.s) != find(now.e)) {
                count ++;
                union(now.s, now.e);
                if(now.c == 0) min ++;
            }
        }
        System.out.println(max * max - min * min);
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

    static class Info {
        int s, e, c;

        public Info(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }
}