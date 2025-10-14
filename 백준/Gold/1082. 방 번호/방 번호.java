import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[] arr = new int[n];
        PriorityQueue<Info> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            queue.add(new Info(i, arr[i]));
        }

        int m = Integer.parseInt(br.readLine());

        if(n == 1) System.out.println(0);
        else {
            int length;
            Info minInfo = queue.poll();
            if (minInfo.num != 0) length = m / minInfo.cost;
            else {
                Info next = queue.poll();

                if(next.cost > m) {
                    length = 0;
                    System.out.println(0);
                } else if(next.cost == m) {
                    length = 0;
                    System.out.println(next.num);
                } else {
                    length = ((m - next.cost) / minInfo.cost) + 1;
                }
            }

            StringBuilder sb = new StringBuilder();
            if(length > 0) {
                int remain = m;
                for (int k = 1; k <= length; k++) {
                    for (int i = n-1; i >= 0; i--) {
                        if(arr[i] > remain) continue;

                        if((length - k) * minInfo.cost <= (remain - arr[i])) {
                            sb.append(i);
                            remain -= arr[i];
                        }
                    }
                }

                System.out.println(sb);
            }
        }


    }

    static class Info implements Comparable<Info>{
        int num, cost;

        @Override
        public int compareTo(Info o) {
            if(this.cost == o.cost) return Integer.compare(o.num, this.num);

            return Integer.compare(this.cost, o.cost);
        }

        public Info(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}