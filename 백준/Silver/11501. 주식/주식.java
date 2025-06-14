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

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tt = 0; tt < T; tt++) {
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Info[] seq = new Info[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
                seq[i] = new Info(arr[i], i);
            }

            Arrays.sort(seq);

            int index = 0;
            long plus = 0;

            for (int i = 0; i < n; i++) {

                if(index >= n) break;
                if(seq[i].index < index) continue;

                long sum = 0;
                int count = 0;
                for (int j = index; j < seq[i].index; j++) {
                    sum += arr[j];
                    count ++;
                }
                plus += (seq[i].v * count - sum);
                index = seq[i].index + 1;
            }
            sb.append(plus).append("\n");
        }

        System.out.print(sb);
    }

    static class Info implements Comparable<Info> {
        long v;
        int index;

        public Info(long v, int index) {
            this.v = v;
            this.index = index;
        }

        @Override
        public int compareTo(Info o) {
            if(this.v == o.v) return o.index - this.index;

            return Long.compare(o.v, this.v);
        }
    }
}