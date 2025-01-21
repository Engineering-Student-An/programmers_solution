import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            queue.add(new Node(start, end, value));
        }

        parent = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            parent[i] = i;
        }

        long sum = 0;
        int count = 0;

        while (count < v - 1) {
            Node poll = queue.poll();

            if(find(poll.start) != find(poll.end)) {
                union(poll.start, poll.end);
                count ++;
                sum += poll.value;
            }
        }

        System.out.println(sum);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if(a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int value;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}