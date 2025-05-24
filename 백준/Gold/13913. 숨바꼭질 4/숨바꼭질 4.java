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
                queue.add(new Info(now.node * 2, now.value + 1));
                result[now.node * 2] = now.value + 1;
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

        StringBuilder sb = new StringBuilder();
        sb.append(result[end]).append("\n");

        int[] route = new int[result[end] + 1];
        int index = end;
        int count = result[end];
        while (true) {
            route[count --] = index;

            if(index == start) break;
            if(index % 2 == 0 && result[index / 2] + 1 == result[index]) {
                index = index/2;
            } else if(index - 1 >= 0 && result[index - 1] + 1 == result[index]) {
                index = index - 1;
            } else if(index + 1 < SIZE && result[index + 1] + 1 == result[index]) {
                index = index + 1;
            }
        }

        for (int i = 0; i <= result[end]; i++) {
            sb.append(route[i]).append(" ");
        }
        System.out.println(sb);
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