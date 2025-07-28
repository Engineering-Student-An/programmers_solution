import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(br.readLine());

            now = find(now);
            if(now == 0) break;
            count ++;
            union(now, now - 1);
        }

        System.out.println(count);
    }

    static int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[a] = b;
    }
}