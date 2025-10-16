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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Info(Math.min(a, b), Math.max(a, b));
        }

        Arrays.sort(arr);

        int d = Integer.parseInt(br.readLine());

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.s, o2.s));

        int max = -1;
        for (int i = 0; i < n; i++) {
            Info now = arr[i];
            int lineStart = arr[i].e - d;

            if(lineStart <= arr[i].s) queue.add(now);

            while(!queue.isEmpty() && queue.peek().s < lineStart) {
                queue.poll();
            }

            max = Math.max(max, queue.size());
        }

        System.out.println(max);
    }

    static class Info implements Comparable<Info>{
        int s, e;

        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.e, o.e);
        }
    }
}