import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static PriorityQueue<Integer>[] adjacentList1;
    static PriorityQueue<Integer>[] adjacentList2;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        adjacentList1 = new PriorityQueue[n+1];
        adjacentList2 = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) {
            adjacentList1[i] = new PriorityQueue<>();
            adjacentList2[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacentList1[a].add(b);
            adjacentList1[b].add(a);
            adjacentList2[a].add(b);
            adjacentList2[b].add(a);
        }
        sb = new StringBuilder();

        boolean[] check = new boolean[n+1];
        dfs(v, check);
        sb.append("\n");

        check = new boolean[n+1];
        bfs(v, check);

        System.out.print(sb);
    }

    private static void bfs(int v, boolean[] check) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        check[v] = true;

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");

            while(!adjacentList2[poll].isEmpty()) {
                Integer integer = adjacentList2[poll].poll();
                if(!check[integer]) {
                    queue.add(integer);
                    check[integer] = true;
                }
            }
        }
    }

    private static void dfs(int v, boolean[] check) {
        sb.append(v).append(" ");
        check[v] = true;

        while(!adjacentList1[v].isEmpty()) {
            Integer poll = adjacentList1[v].poll();
            if(!check[poll]) {
                dfs(poll, check);
            }
        }
    }


}