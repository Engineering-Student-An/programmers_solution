import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Info[] arr = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.end, o2.end));
        for (int i = 0; i < n; i++) {
            if(queue.isEmpty()) queue.add(arr[i]);
            else {
                if(queue.peek().end <= arr[i].start) queue.poll();
                queue.add(arr[i]);
            }
        }

        System.out.println(queue.size());
    }

    static class Info implements Comparable<Info> {

        int num, start, end;

        public Info(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Info o) {
            if(this.start == o.start) return (this.end - o.end);
            return this.start - o.start;
        }

    }
}