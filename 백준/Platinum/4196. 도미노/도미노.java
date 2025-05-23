import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
            }

            visited = new boolean[n + 1];
            stack = new Stack<>();

            // 1단계: 후위순서 스택 쌓기
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            // 2단계: 스택에서 꺼내며 새 탐색 시작 → 손으로 넘어뜨려야 하는 도미노 수
            Arrays.fill(visited, false);
            int result = 0;
            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (!visited[node]) {
                    dfs2(node);
                    result++;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
        stack.push(node);
    }

    static void dfs2(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs2(next);
            }
        }
    }
}
