import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static List<Info>[] adjacencyList;
    static int[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(new Info(v, value));
            adjacencyList[v].add(new Info(u, value));
        }

        result = new int[n+1][2];

        dijkstra();

//        for (int i = 1; i <= n; i++) {
//            System.out.println(result[i][0]);
//            System.out.println(result[i][1]);
//        }
        System.out.println((result[n][1] == 1) ? "SAVE HIM" : "GOOD BYE");
    }

    static void dijkstra() {
        for (int i = 2; i <= n; i++) {
            result[i][0] = Integer.MAX_VALUE;
        }

        if(k == 1) result[1][1] = 1;

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));
        queue.add(new Info(1, 0));

        while(!queue.isEmpty()) {
            Info now = queue.poll();

            for (Info next : adjacencyList[now.node]) {
                if(result[next.node][0] > result[now.node][0] + next.value) {
                    result[next.node][0] = result[now.node][0] + next.value;
                    if(next.node == k) result[next.node][1] = 1;
                    else result[next.node][1] = result[now.node][1];
                    queue.add(new Info(next.node, result[next.node][0]));
                } else if(result[next.node][0] == result[now.node][0] + next.value) {
                    if(result[next.node][1] == 0 && result[now.node][1] == 1) {
                        result[next.node][1] = result[now.node][1];
                        queue.add(new Info(next.node, result[next.node][0]));
                    }
                }
            }
        }
    }

    static class Info {
        int node, value;

        public Info(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}