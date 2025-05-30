import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k;
    static List<Integer>[] adjacencyList, reverseAdjacencyList;
    static int[] depth;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tt = 0; tt < testcase; tt++) {
            n = Integer.parseInt(br.readLine());

            adjacencyList = new ArrayList[n+1];
            reverseAdjacencyList = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
                reverseAdjacencyList[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adjacencyList[u].add(v);
                reverseAdjacencyList[v].add(u);
            }

            depth = new int[n+1];
            int root = findRoot();

            int height = -1;
            for (int i = 1; i <= n; i++) {
                height = Math.max(height, depth[i]);
            }

            while(Math.pow(2, k) < height) {
                k ++;
            }

            arr = new int[k][n+1];
            firstParent(root);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static int lca(int a, int b) {

        // depth 맞추기
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b =temp;
        }

        int h = k-1;
        while(depth[a] < depth[b]) {
            if(depth[a] <= depth[arr[h][b]]) {
                b = arr[h][b];
            }
            h --;
        }

        // lca 찾기
        if(a == b) return a;

        for (int i = k-1; i >= 0; i--) {
            if(arr[i][a] != arr[i][b]){
                a = arr[i][a];
                b = arr[i][b];
            }
        }

        return arr[0][a];
    }

    static void firstParent(int root) {
        boolean[] visit = new boolean[n+1];
        visit[root] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Integer next : adjacencyList[now]) {
                if(!visit[next]) {
                    visit[next] = true;
                    arr[0][next] = now;
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = arr[i-1][arr[i-1][j]];
            }
        }
    }

    static int findRoot() {
        boolean[] visit = new boolean[n+1];
        visit[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        depth[1] = 1;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : adjacencyList[now]) {
                if(!visit[next]) {
                    visit[next] = true;
                    depth[next] = depth[now] + 1;
                    queue.add(next);
                }
            }

            for (Integer next : reverseAdjacencyList[now]) {
                if(!visit[next]) {
                    visit[next] = true;
                    depth[next] = depth[now] - 1;
                    queue.add(next);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if(min > depth[i]){
                min = depth[i];
                root = i;
            }
        }

        if(root == 1) return 1;

        for (int i = 1; i <= n; i++) {
            depth[i] -= min - 1;
        }
        return root;
    }

}