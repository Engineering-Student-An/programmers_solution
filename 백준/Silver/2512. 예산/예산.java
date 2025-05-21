import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[] want;
    static long money;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        want = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            want[i] = Long.parseLong(st.nextToken());
            sum += want[i];
        }

        money = Long.parseLong(br.readLine());

        if(money >= sum) {
            long max = -1;
            for (int i = 0; i < n; i++) {
                max = Math.max(want[i], max);
            }
            System.out.println(max);
        } else {
            long start = 1;
            long end = money;

            while(start <= end) {
                long middle = (start + end) / 2;

                sum = check(middle);
                if(sum == money) {
                    end = middle;
                    break;
                } else if(sum < money) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }

            System.out.println(end);
        }
    }

    static long check(long middle) {

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(middle, want[i]);
        }

        return sum;
    }
}