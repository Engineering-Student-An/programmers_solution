import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] adjacencyList;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new List[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(end);
            adjacencyList[end].add(start);
        }

        visit = new boolean[n+1];

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(!visit[i]) {
                bfs(i);
                count ++;
            }
        }

        System.out.println(count);
    }

    static void bfs(int i) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visit[i] = true;

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer integer : adjacencyList[poll]) {
                if(!visit[integer]) {
                    visit[integer] = true;
                    queue.add(integer);
                }
            }
        }
    }
}