import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static int n, m;
    static int[][] arr;
    static PriorityQueue<Edge> edges = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandCount = initialIsland();

        initialEdges(islandCount);

        parent = new int[islandCount + 1];
        for (int i = 0; i <= islandCount; i++) {
            parent[i] = i;
        }

        System.out.println(minimumSpanningTree(islandCount));
    }

    static int minimumSpanningTree(int islandCount) {
        int count = 0;
        int sum = 0;

        while(!edges.isEmpty() && count < islandCount - 1) {
            Edge edge = edges.poll();

            if(find(parent[edge.s]) != find(parent[edge.e])) {
                union(edge.s, edge.e);
                sum += edge.v;
                count ++;
            }
        }

        if(count < islandCount - 1) return -1;
        return sum;
    }

    static int find(int a) {
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }

    static void initialEdges(int count) {

        int[][] adjMatrix = new int[count + 1][count + 1];
        for (int i = 0; i <= count; i++) {
            for (int j = 0; j <= count; j++) {
                adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextRow = i + dirRow[k];
                        int nextCol = j + dirCol[k];

                        if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] == 0) {
                            Edge edge = findIsland(i, j, dirRow[k], dirCol[k], arr[i][j]);
                            if(edge != null && edge.v > 1) {
                                adjMatrix[edge.s][edge.e] = Math.min(adjMatrix[edge.s][edge.e], edge.v);
                                adjMatrix[edge.e][edge.s] = Math.min(adjMatrix[edge.e][edge.s], edge.v);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= count; i++) {
            for (int j = i+1; j <= count; j++) {
                if(adjMatrix[i][j] != Integer.MAX_VALUE) edges.add(new Edge(i, j, adjMatrix[i][j]));
            }
        }
    }

    static Edge findIsland(int r, int c, int nextRow, int nextCol, int num) {

        r += nextRow;
        c += nextCol;
        int distance = 1;

        while(r >= 0 && c >= 0 && r < n && c < m) {
            if(arr[r][c] == num) return null;

            if(arr[r][c] != 0) return new Edge(num, arr[r][c], distance-1);

            r += nextRow;
            c += nextCol;
            distance ++;
        }

        return null;
    }

    static class Edge {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }


    static int initialIsland() {

        int num = 1;

        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && !visit[i][j]) bfs(i, j, visit, num ++);
            }
        }

        return num-1;
    }

    static void bfs(int i, int j, boolean[][] visit, int num) {

        visit[i][j] = true;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(i, j));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            arr[now.row][now.col] = num;

            for (int k = 0; k < 4; k++) {
                int nextRow = now.row + dirRow[k];
                int nextCol = now.col + dirCol[k];

                if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] == 1 && !visit[nextRow][nextCol]) {
                    queue.add(new Info(nextRow, nextCol));
                    visit[nextRow][nextCol] = true;
                }
            }
        }
    }

    static class Info {
        int row;
        int col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}