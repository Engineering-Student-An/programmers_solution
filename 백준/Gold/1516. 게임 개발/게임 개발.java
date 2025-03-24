import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] adjacencyList;
    static int n;
    static long[] result;
    static long[] times;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        inDegree = new int[n+1];
        times = new long[n+1];
        result = new long[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Long.parseLong(st.nextToken());
            while(true) {
                int v = Integer.parseInt(st.nextToken());
                if(v == -1) break;
                adjacencyList[v].add(i);
                inDegree[i] ++;
            }
        }

        build();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result[i] += times[i];
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void build() {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer i : adjacencyList[poll]) {
                inDegree[i] --;
                result[i] = Math.max(result[i], result[poll] + times[poll]);

                if(inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }
}