import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> queue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.w == o2.w) return o2.v - o1.v;

                return o2.w - o1.w;
            }
        });


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Integer[] bags = new Integer[m];
        for (int i = 0; i < m; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags, Collections.reverseOrder());

        PriorityQueue<Info> result = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.v == o2.v) return o2.w - o1.w;

                return o1.v - o2.v;
            }
        });

        int index = 0;
        long sum = 0;
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            if(index < m && now.w <= bags[index]) {
                result.add(now);
                sum += now.v;
                index ++;
            } else if(!result.isEmpty()) {
                Info minBag = result.poll();
                if(now.v > minBag.v) {
                    sum -= minBag.v;
                    sum += now.v;
                    result.add(now);
                }
                else result.add(minBag);
            }
        }

        System.out.println(sum);
    }

    static class Info {
        int w, v;

        public Info(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}