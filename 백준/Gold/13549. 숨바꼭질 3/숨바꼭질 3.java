import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int start, end;
    static final int SIZE = 200002;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int[] result = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[start] = 0;

        PriorityQueue<Info> queue = new PriorityQueue<>();
        queue.add(new Info(start, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(result[now.node] < now.value) continue;

            if(now.node <= 100000 && now.node > 0 && result[now.node * 2] == Integer.MAX_VALUE) {
                queue.add(new Info(now.node * 2, now.value));
                result[now.node * 2] = now.value;
            }
            if(now.node <= 200000 && result[now.node + 1] == Integer.MAX_VALUE) {
                queue.add(new Info(now.node + 1, now.value + 1));
                result[now.node + 1] = now.value + 1;
            }
            if(now.node > 0 && result[now.node - 1] == Integer.MAX_VALUE) {
                queue.add(new Info(now.node - 1, now.value + 1));
                result[now.node - 1] = now.value + 1;
            }
        }

        System.out.println(result[end]);
    }

    static class Info implements Comparable<Info> {
        int node;
        int value;

        public Info(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Info o) {
            if(this.value == o.value) return Integer.compare(this.node, o.node);

            return Integer.compare(this.value, o.value);
        }
    }
}