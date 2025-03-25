import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacencyList[u].add(v);
            inDegree[v] ++;
        }

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            sb.append(poll).append(" ");
            for (Integer i : adjacencyList[poll]) {
                inDegree[i] --;

                if(inDegree[i] == 0) queue.add(i);
            }
        }

        System.out.println(sb);
    }
}