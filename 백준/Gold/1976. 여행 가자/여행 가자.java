import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visit;
    static int n, m;
    static int[] travelList;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int isPossible = Integer.parseInt(st.nextToken());
                if(isPossible == 1) {
                    adjacencyList[i].add(j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        travelList = new int[m];
        for (int i = 0; i < m; i++) {
            travelList[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n+1];
        parent = new int[n+1];


        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            if(!visit[i]) {
                bfs(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            find(i);
        }

        int plan = parent[travelList[0]];
        boolean isPossible = true;
        for (int i = 1; i < m; i++) {
            if (parent[travelList[i]] != plan) isPossible = false;
        }

        System.out.println((isPossible) ? "YES" : "NO");
    }

    static void bfs(int num) {

        visit[num] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer i : adjacencyList[poll]) {
                if(!visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    union(num, i);
                }
            }
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!=b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }
}