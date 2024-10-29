import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Data>[] adjacentList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

         adjacentList = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while(true) {
                String t = st.nextToken();
                if(t.equals("-1")) break;

                int node = Integer.parseInt(t);
                int value = Integer.parseInt(st.nextToken());
                adjacentList[v].add(new Data(node, value));
            }
        }

        int[] distance = new int[n+1];

        bfs(1, distance);

        int max_ind = 0;
        int max = -1;
        for (int i=1; i<=n; i++) {
            if(max < distance[i]) {
                max = distance[i];
                max_ind = i;
            }
        }

        distance = new int[n+1];
        bfs(max_ind, distance);

        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    private static void bfs(int v, int[] distance) {
        boolean[] check = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        check[v] = true;

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Data data : adjacentList[poll]) {
                if(!check[data.node]) {
                    queue.add(data.node);
                    check[data.node] = true;
                    distance[data.node] = distance[poll] + data.value;
                }
            }
        }
    }

    static class Data {
        int node;
        int value;

        public Data(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}