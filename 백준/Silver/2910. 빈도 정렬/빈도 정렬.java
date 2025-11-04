import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            first.putIfAbsent(num, i);

            if(count.get(num) != null) count.replace(num, count.get(num) + 1);
            else count.put(num, 1);
        }

        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (Integer num : first.keySet()) {
            queue.add(new Info(num, first.get(num), count.get(num)));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < now.count; i++) {
                sb.append(now.num + " ");
            }
        }

        System.out.print(sb);
    }

    static class Info implements Comparable<Info> {
        int num, first, count;

        public Info(int num, int first, int count) {
            this.num = num;
            this.first = first;
            this.count = count;
        }

        @Override
        public int compareTo(Info o) {
            if(this.count == o.count) return Integer.compare(this.first, o.first);

            return Integer.compare(o.count, this.count);
        }
    }
}