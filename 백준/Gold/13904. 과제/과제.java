import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Info> arr = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.d == o2.d) return Integer.compare(o1.v, o2.v);

                return Integer.compare(o1.d, o2.d);
            }
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
        while (!arr.isEmpty()) {
            Info now = arr.poll();

            queue.add(now);
            if(queue.size() > now.d) queue.poll();
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll().v;
        }
        System.out.println(sum);
    }

    static class Info {
        int d, v;

        public Info(int d, int v) {
            this.d = d;
            this.v = v;
        }
    }
}