import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(new Info(i, Long.parseLong(st.nextToken())));
        }

        int c = -1;
        long before = Long.MAX_VALUE;
        int[] result = new int[n];
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(before != now.value) {
                result[now.index] = ++c;
                before = now.value;
            } else {
                result[now.index] = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

    static class Info implements Comparable<Info> {
        int index;
        long value;

        public Info(int index, long value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Info o) {
            return Long.compare(this.value, o.value);
        }
    }
}