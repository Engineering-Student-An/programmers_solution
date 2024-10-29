import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] adjacentList = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacentList[u][v] = true;
            adjacentList[v][u] = true;
        }

        boolean[] visited = new boolean[n+1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            Stack<Integer> stack = new Stack<>();

            if(!visited[i]) {
                stack.add(i);
                result ++;
            }
            while(!stack.isEmpty()) {
                Integer pop = stack.pop();
                visited[pop] = true;

                for (int j = 1; j <= n; j++) {
                    if(adjacentList[pop][j] && !visited[j]) {
                        stack.add(j);
                    }
                }

            }
        }

        System.out.println(result);
    }
}