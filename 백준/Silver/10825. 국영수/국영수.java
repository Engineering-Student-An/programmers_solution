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

        PriorityQueue<Info> queue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.k == o2.k) {
                    if(o1.e == o2.e) {
                        if(o1.m == o2.m) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.m - o1.m;
                    }
                    return o1.e - o2.e;
                }
                return o2.k - o1.k;
            }
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            queue.add(new Info(name, k, e, m));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            sb.append(now.name).append("\n");
        }

        System.out.print(sb);
    }

    static class Info {
        String name;
        int k, e, m;

        public Info(String name, int k, int e, int m) {
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }
    }
}