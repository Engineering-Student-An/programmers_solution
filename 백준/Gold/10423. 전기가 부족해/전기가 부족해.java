import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static boolean[] check;
    static int[] parent;
    static PriorityQueue<Info> edgeList = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        check = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) check[Integer.parseInt(st.nextToken())] = true;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            edgeList.add(new Info(s, e, value));
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int remain = n - k;
        int sum = 0;
        while(remain > 0) {

            Info now = edgeList.poll();

            if(find(now.s) != find(now.e) && !(check[now.s] && check[now.e])) {
                int u = union(now.s, now.e);
                sum += now.value;

                if(check[now.s] || check[now.e]) {
                    for (int i = 1; i <= n; i++) {
                        if(find(i) == u && !check[i]) {
                            check[i] = true;
                            remain --;
                        }
                    }
                }
            }
        }

        System.out.println(sum);
    }

    static int union(int a, int b) {
        a = find(a);
        b = find(b);

        parent[Math.max(a, b)] = Math.min(a, b);

        return Math.min(a, b);
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static class Info {
        int s, e, value;

        public Info(int s, int e, int value) {
            this.s = s;
            this.e = e;
            this.value = value;
        }
    }
}