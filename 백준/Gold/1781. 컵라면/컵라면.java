import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long d = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            queue.add(new Info(d, c));
        }

        PriorityQueue<Info> result = new PriorityQueue<>((o1, o2) -> Long.compare(o1.c, o2.c));
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            result.add(now);
            while(result.size() > now.d) result.poll();
        }

        long count = 0;
        while (!result.isEmpty()) {
            count += result.poll().c;
        }

        System.out.println(count);
    }

    static class Info implements Comparable<Info> {
        long d, c;

        public Info(long d, long c) {
            this.d = d;
            this.c = c;
        }

        @Override
        public int compareTo(Info o) {
            if(this.d == o.d) return Long.compare(o.c, this.c);

            return Long.compare(this.d, o.d);
        }
    }
}