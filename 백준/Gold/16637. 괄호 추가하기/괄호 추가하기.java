import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static long ans = Long.MIN_VALUE;
    static long[] nums;
    static char[] ops;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String line = br.readLine();
        n = line.length() / 2 + 1;
        m = line.length() / 2;
        nums = new long[n];
        ops = new char[m];

        int nIndex = 0;
        int oIndex = 0;
        for (int i = 0; i < line.length(); i++) {
            if(i % 2 == 0) nums[nIndex ++] = line.charAt(i) - '0';
            else ops[oIndex++] = line.charAt(i);
        }

        lastCalc(nums, ops);

        for (int k = 1; k <= n/2; k++) {
            for (int i = 0; i <= n - (2 * k); i++) {
                long[] tempNums = new long[n];
                char[] tempOps = new char[m];

                for (int j = 0; j < n; j++) {
                    tempNums[j] = nums[j];
                }

                for (int j = 0; j < m; j++) {
                    tempOps[j] = ops[j];
                }

                tempNums[i] = calc(tempNums[i], tempNums[i + 1], tempOps[i]);
                tempNums[i + 1] = Long.MAX_VALUE;
                tempOps[i] = ' ';

                gwal(i, tempNums, tempOps, k, 1);
            }
        }

        System.out.println(ans);
    }

    static void gwal(int index, long[] tNums, char[] tOps, int k, int count) {

        if(count == k) {
            lastCalc(tNums, tOps);
            return;
        }

        for (int i = index + 2; i < n - 1; i++) {
            tNums[i] = calc(tNums[i], tNums[i + 1], tOps[i]);
            tNums[i + 1] = Long.MAX_VALUE;
            tOps[i] = ' ';

            gwal(i, tNums, tOps, k, count + 1);

            tNums[i] = nums[i];
            tNums[i + 1] = nums[i + 1];
            tOps[i] = ops[i];
        }
    }

    static long calc(long a, long b, char op) {
        if(op == '+') return a + b;
        else if(op == '-') return a - b;
        else if(op == '*') return a * b;
        else return 0;
    }

    static void lastCalc(long[] nums, char[] ops) {
        int nn = 0, oo = 0;
        long a = 0, b = Long.MAX_VALUE;
        char op = ' ';

        while(nn < n) {
            if(nums[nn] != Long.MAX_VALUE) {
                a = nums[nn];
                break;
            }
            nn ++;
        }

        nn ++;
        while(nn < n && oo < m) {
            if(nums[nn] != Long.MAX_VALUE) b = nums[nn];
            if(ops[oo] != ' ') op = ops[oo];

            if(b != Long.MAX_VALUE && op != ' ') {
                a = calc(a, b, op);
                b = Long.MAX_VALUE;
                op = ' ';
            }

            nn ++;
            oo ++;
        }

        ans = Math.max(ans, a);
    }
}
