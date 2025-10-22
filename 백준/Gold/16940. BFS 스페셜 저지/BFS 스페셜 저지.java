import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] seq;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        seq = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            seq[num] = i;
        }

        PriorityQueue<Info>[] adjacencyList = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new PriorityQueue<>();

            for (Integer j : list[i]) {
                adjacencyList[i].add(new Info(j, seq[j]));
            }
        }

        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int count = 2;
        boolean isImpossible = false;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            while (!adjacencyList[now].isEmpty()) {
                Info next = adjacencyList[now].poll();

                if(visit[next.num]) continue;

                if(next.seq != count) {
                    isImpossible = true;
                    break;
                }

                visit[next.num] = true;
                queue.add(next.num);
                count ++;
            }

            if(isImpossible) break;
        }

        System.out.println((isImpossible) ? 0 : 1);
    }

    static class Info implements Comparable<Info>{
        int num, seq;

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.seq, o.seq);
        }

        public Info(int num, int seq) {
            this.num = num;
            this.seq = seq;
        }
    }
}