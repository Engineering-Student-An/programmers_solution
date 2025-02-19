import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer>[] adjacencyList;
    static int[] parents;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        visit = new boolean[n+1];

        adjacencyList = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        dfs(1);

        for (int i = 2; i < n+1; i++) {
            System.out.println(parents[i]);
        }
    }

    static void dfs(int node) {

        for (Integer i : adjacencyList[node]) {
            if(!visit[i]) {
                visit[i] = true;
                parents[i] = node;
                dfs(i);
            }
        }
    }
}