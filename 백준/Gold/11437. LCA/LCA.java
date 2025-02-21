import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] adjacencyList;
    static int n;
    static int[][] parent;
    static int[] firstParent;
    static int[] depthList;
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        firstParent = new int[n+1];
        depthList = new int[n+1];
        Arrays.fill(depthList, -1); // 깊이 리스트 초기화
        depthList[1] = 0; // 루트 노드의 깊이는 0
        int level = depthOfTree();

        k = 0;
        while(level >= (1 << k)) { // 2^k로 깊이 계산
            k++;
        }
        k--;

        parent = new int[k+1][n+1];

        // 부모 배열 초기화
        for (int i = 1; i <= n; i++) {
            parent[0][i] = firstParent[i];
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (parent[i-1][j] != 0) {
                    parent[i][j] = parent[i-1][parent[i-1][j]];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static int lca(int a, int b) {
        if (depthList[a] < depthList[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 깊이 맞추기
        int depthDifference = depthList[a] - depthList[b];
        for (int i = k; i >= 0; i--) {
            if ((depthDifference & (1 << i)) != 0) {
                a = parent[i][a];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = k; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        return firstParent[a];
    }

    static int depthOfTree() {
        boolean[] visit = new boolean[n+1];
        visit[1] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));

        int depth = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            depth = Math.max(depth, poll.depth);

            for (Integer integer : adjacencyList[poll.value]) {
                if(!visit[integer]) {
                    queue.add(new Node(integer, poll.depth + 1));
                    visit[integer] = true;
                    firstParent[integer] = poll.value;
                    depthList[integer] = poll.depth + 1;
                }
            }
        }

        return depth;
    }

    static class Node {
        int value;
        int depth;

        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}
