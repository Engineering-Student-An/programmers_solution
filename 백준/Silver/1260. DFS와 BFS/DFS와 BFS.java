import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();

        PriorityQueue<Integer>[] adj = new PriorityQueue[n+1];
        PriorityQueue<Integer>[] adj2 = new PriorityQueue[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new PriorityQueue<Integer>();
            adj2[i] = new PriorityQueue<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            adj[start].add(end);
            adj2[start].add(end);
            adj[end].add(start);
            adj2[end].add(start);
        }

        boolean[] dfs_chk = new boolean[n + 1];
        boolean[] bfs_chk = new boolean[n + 1];

        // dfs
        dfs(adj, v, dfs_chk);

        System.out.println();

        // bfs
        bfs(adj2, v, bfs_chk);
    }

    private static void bfs(PriorityQueue<Integer>[] adj, int v, boolean[] bfsChk) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        bfsChk[v] = true;
        while(!queue.isEmpty()){
            v = queue.poll();
            System.out.print(v + " ");
            while(!adj[v].isEmpty()){
                int a = adj[v].poll();
                if(!bfsChk[a]){
                    queue.add(a);
                    bfsChk[a] = true;
                }
            }
        }
    }

    private static void dfs(PriorityQueue<Integer>[] adj, int v, boolean[] dfsChk) {
        System.out.print(v + " ");
        dfsChk[v] = true;
        while(!adj[v].isEmpty()){
            int a = adj[v].poll();
            if(!dfsChk[a]) dfs(adj, a, dfsChk);
        }
    }


}
