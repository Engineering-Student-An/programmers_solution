import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] plusDate = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    static PriorityQueue<Info> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(c >= 3) convertToInfo(a, b, c, d);
        }

        int count = 0;
        int before = 59;
        boolean isPossible = true;
        while (!queue.isEmpty()) {

            Info now = null;

            while(!queue.isEmpty() && queue.peek().s <= before + 1) {
                Info info = queue.poll();

                if(now == null) now = info;
                else {
                    if(now.e < info.e) now = info;
                }
            }

            if(now == null) {
                isPossible = false;
                break;
            }

            count ++;
            before = now.e - 1;

            if(before >= 334) break;
        }

        if(!isPossible || before < 334) System.out.println(0);
        else System.out.println(count);
    }

    static void convertToInfo(int a, int b, int c, int d) {
        int s = b;
        int e = d;
        s += plusDate[a];
        e += plusDate[c];

        queue.add(new Info(s, e));
    }

    static class Info implements Comparable<Info>{
        int s, e;

        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Info o) {
            if(this.s == o.s) return Integer.compare(o.e, this.e);

            return Integer.compare(this.s, o.s);
        }
    }
}