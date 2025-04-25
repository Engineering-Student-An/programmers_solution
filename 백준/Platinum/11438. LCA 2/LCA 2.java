import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static ArrayList<Integer>[] adjacencyList;
    static int[] firstParent;
    static int[][] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        depth = new int[n + 1];
        firstParent = new int[n+1];
        int height = checkDepth();

        k = 0;
        while(Math.pow(2, k) < height) {
            k ++;
        }

        parent = new int[k][n+1];
        for (int i = 1; i <= n; i++) {
            parent[0][i] = firstParent[i];
        }

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(fastLca(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    static int fastLca(int a, int b) {

        // 깊이 맞추기
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int h = k-1;
        while(depth[a] < depth[b]) {
            if(depth[a] <= depth[parent[h][b]]) {
                b = parent[h][b];
            }
            h--;
        }

        // 2^h 만큼 올라가면서 조상이 겹치는 곳 찾기
        h = 0;
        while(h < k && parent[h][a] != parent[h][b]) {
            h ++;
        }

        // 최소공통조상 찾기
        if(a == b) {
            return a;
        }
        for (int i = k-1; i >= 0; i--) {
            if(parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        return parent[0][a];
    }

    static int checkDepth() {

        int maxDepth = -1;
        boolean[] visit = new boolean[n+1];
        visit[1] = true;
        depth[1] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer i : adjacencyList[now]) {
                if(!visit[i]) {
                    visit[i] = true;
                    firstParent[i] = now;
                    queue.add(i);
                    depth[i] = depth[now] + 1;
                    maxDepth = Math.max(maxDepth, depth[i]);
                }
            }
        }

        return maxDepth;
    }
}