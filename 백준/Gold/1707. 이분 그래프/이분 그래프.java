import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {

            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] adjacencyList = new ArrayList[v+1];
            for (int j = 0; j <= v; j++) {
                adjacencyList[j] = new ArrayList<>();
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                adjacencyList[v1].add(v2);
                adjacencyList[v2].add(v1);
            }

            int[] visit = new int[v+1];
            for (int j = 1; j <= v; j++) {
                visit[j] = 0;
            }

            result = true;
            for (int j = 1; j <= v; j++) {
                if(visit[j] == 0) {
                    bfs(j, adjacencyList, visit, 1);
                }
                if(!result) break;
            }
            System.out.println( (result) ? "YES" : "NO");
        }
    }

    public static void bfs(int v, ArrayList<Integer>[] adjacencyList, int[] visit, int color) {

        visit[v] = color;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();
            for(Integer i : adjacencyList[poll]) {
                if(visit[i] == 0) {
                    visit[i] = visit[poll] * -1;
                    queue.add(i);
                }
                else if(visit[poll] + visit[i] != 0) {
                    result = false;
                    return;
                }
            }
        }
    }
}