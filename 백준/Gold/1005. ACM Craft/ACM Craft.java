import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Integer>[] adjacencyList;
    static long[] result;
    static long[] times;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int testcase = 0; testcase < t; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            adjacencyList = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            times = new long[n+1];
            result = new long[n+1];
            inDegree = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                times[i] = Long.parseLong(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adjacencyList[u].add(v);
                inDegree[v] ++;
            }

            int end = Integer.parseInt(br.readLine());
            
            topologicalSort();


            sb.append(result[end] + times[end]).append("\n");
        }

        System.out.print(sb);
    }
    
    static void topologicalSort() {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer i : adjacencyList[poll]) {
                inDegree[i] --;
                if(inDegree[i] == 0) queue.add(i);
                
                result[i] = Math.max(result[i], times[poll] + result[poll]);
            }
        }
    }
}