import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] adjacencyList;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        result = new int[n+1];
        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(end);
        }

        boolean[] visit = new boolean[n+1];

        bfs(x, visit);

        StringBuilder sb = new StringBuilder();
        boolean count = false;
        for (int i = 1; i <= n; i++) {
            if(result[i] == k) {
                sb.append(i).append("\n");
                count = true;
            }
        }

        System.out.print( (count) ? sb : -1);
    }

    private static void bfs(int v, boolean[] visit) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        visit[v] = true;
        result[v] = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer i : adjacencyList[poll]) {
                if(!visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    result[i] = result[poll] + 1;
                }
            }
        }
    }
}