import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.start, o2.start));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            queue.add(new Info(start, end - 1));
        }

        int fin = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(fin >= now.end) continue;
            if(fin >= now.start) now.start = fin + 1;

            int dist = now.end - now.start + 1;
            int plus = (dist % l == 0) ? dist/l : dist/l + 1;
            result += plus;
            fin = now.start + (plus * l) - 1;

        }

        System.out.println(result);
    }

    static class Info {
        int start, end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}