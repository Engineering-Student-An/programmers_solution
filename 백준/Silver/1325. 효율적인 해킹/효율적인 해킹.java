import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] adjacencyList;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            adjacencyList[start].add(end);
        }

        result = new int[n+1];

        for (int i = 1; i <= n; i++) {
            bfs(n, i);
        }

        int max = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(max < result[i]) {
                max = result[i];
                sb = new StringBuilder();
                sb.append(i).append(" ");
            } else if(max == result[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.print(sb);
    }

    public static void bfs(int n, int v) {
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        
        queue.add(v);
        
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visit[poll] = true;

            for (Integer i : adjacencyList[poll]) {
                if(!visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                    result[i] ++;
                }
            }
        }
    }
}