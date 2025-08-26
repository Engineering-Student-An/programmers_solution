import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Info[] arr = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.start == o2.start) return Integer.compare(o1.end, o2.end);
                return Integer.compare(o1.start, o2.start);
            }
        });

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.end, o2.end));
        for (int i = 0; i < n; i++) {
            if(!queue.isEmpty() && queue.peek().end <= arr[i].start) queue.poll();
            queue.add(arr[i]);
        }

        System.out.println(queue.size());

    }

    static class Info {
        int start, end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}