import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(result == 0 && find(u) == find(v)) {
                result = i;
            } else if(result == 0 && find(u) != find(v)){
                union(u, v);
            }
        }

        System.out.println(result);
    }

    static int find(int a) {
        if(a == parents[a]) return a;

        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parents[Math.max(a, b)] = parents[Math.min(a, b)];
        }
    }
}