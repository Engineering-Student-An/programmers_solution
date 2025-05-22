import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Info[] arr = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Info(start, end);
        }

        Arrays.sort(arr, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.start == o2.start) return o1.end - o2.end;

                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(queue.isEmpty()) {
                count ++;
            } else {
                if(queue.peek() > arr[i].start) {
                    if(queue.size() >= count) count ++;
                }
                else {
                    while(!queue.isEmpty() && queue.peek() <= arr[i].start) {
                        queue.poll();
                    }
                }
            }
            queue.add(arr[i].end);
        }

        System.out.println(count);
    }

    static class Info implements Comparable<Info> {
        int start;
        int end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Info o) {
            if(this.end == o.end) return this.start - o.start;

            return this.end - o.end;
        }
    }
}