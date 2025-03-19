import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Time> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            queue.add(new Time(start, end));
        }

        long result = 0;
        long before = -1;
        while (!queue.isEmpty()) {
            Time now = queue.poll();

            if(now.start >= before) {
                before = now.end;
                result ++;
            }
        }

        System.out.println(result);
    }

    static class Time implements Comparable<Time>{
        long start;
        long end;

        public Time(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end == o.end) {
                return (this.start < o.start) ? -1 : 1;
            }
            return (this.end < o.end) ? -1 : 1;
        }
    }
}