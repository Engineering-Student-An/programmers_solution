import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] adjacencyList;
    static boolean[] visit;
    static boolean isFound;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        if(m < 4) {
            System.out.println(0);
        } else {
            visit = new boolean[n];
            for (int i = 0; i < n; i++) {
                if(isFound) break;
                visit[i] = true;
                dfs(i, 0);
                visit[i] = false;
            }

            System.out.println(isFound ? 1 : 0);
        }
    }

    static void dfs(int num, int count) {

        if(count == 4 || isFound) {
            isFound = true;
            return;
        }

        for(Integer i : adjacencyList[num]) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i, count+1);
                visit[i] = false;
            }
        }
    }
}