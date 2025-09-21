import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] adjacencyList;
    static long[] plus;
    static long[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) continue;

            adjacencyList[parent].add(i);
        }

        plus = new long[n + 1];
        result = new long[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            plus[a] += b;
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(1, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            result[now.num] = now.p + plus[now.num];
            for (Integer next : adjacencyList[now.num]) {
                queue.add(new Info(next, result[now.num]));
            }
        }
    }

    static class Info {
        int num;
        long p;

        public Info(int num, long p) {
            this.num = num;
            this.p = p;
        }
    }
}