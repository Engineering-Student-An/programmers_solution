import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static Set<Integer> sosu = new HashSet<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        so();

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            visit = new boolean[10000];

            int result = check();
            sb.append(result == Integer.MAX_VALUE ? "Impossible" : result).append("\n");
        }

        System.out.print(sb);
    }

    static void so() {
        for (int i = 1000; i < 10000; i++) {
            int sq = (int) Math.sqrt(i);
            boolean found = true;
            for (int j = 2; j <= sq; j++) {
                if(i % j == 0) {
                    found = false;
                    break;
                }
            }

            if(found) sosu.add(i);
        }
    }

    static int check() {

        if(n == m) return 0;
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        queue.add(new Info(new int[] {n / 1000, n % 1000 / 100, n % 100 / 10, n % 10}, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 3; i >= 0; i--) {
                int[] changes = change(now.nums, i);
                for(int next : changes) {
                    if(next == m) return now.count + 1;

                    if(next >= 1000 && sosu.contains(next) && !visit[next]) {
                        visit[next] = true;
                        queue.add(new Info(new int[]{next / 1000, next % 1000 / 100, next % 100 / 10, next % 10}, now.count + 1));
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static int[] change(int[] nums, int i) {
        int[] temp = new int[4];
        for (int j = 0; j < 4; j++) {
            temp[j] = nums[j];
        }
        int[] results = new int[9];
        int index = 0;
        int t = nums[i];
        for (int j = 0; j < 10; j++) {
            if(j != t) {
                temp[i] = j;
                results[index ++] = 1000 * temp[0] + 100 * temp[1] + 10 * temp[2] + temp[3];
            }
        }

        return results;
    }

    static class Info {
        int[] nums;
        int count;

        public Info(int[] nums, int count) {
            this.nums = nums;
            this.count = count;
        }
    }
}