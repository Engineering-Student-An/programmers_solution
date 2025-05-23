import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int v, e;
    static ArrayList<Integer>[] adjacencyList;
    static int[] color;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testcase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            adjacencyList = new ArrayList[v+1];
            for (int i = 0; i <= v; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                adjacencyList[start].add(end);
                adjacencyList[end].add(start);
            }

            boolean isPossible = true;
            color = new int[v+1];
            for (int i = 1; i <= v && isPossible; i++) {
                if(color[i] == 0) {
                    isPossible = bfs(i);
                }
            }


            sb.append(isPossible ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    static boolean bfs(int start) {

        color[start] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Integer next : adjacencyList[now]) {
                if(color[next] == 0) {
                    color[next] = color[now] * -1;
                    queue.add(next);
                } else if (color[now] == color[next]) {
                    return false;
                }
            }
        }

        return true;
    }
}