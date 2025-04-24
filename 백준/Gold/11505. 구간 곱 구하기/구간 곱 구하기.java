import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, c;
    static int k = 0;
    static int size;
    static long[] segmentTree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        while (Math.pow(2, k) <= n) {
            k++;
        }

        size = (int) (Math.pow(2, k + 1));
        segmentTree = new long[size];
        for (int i = size / 2; i < n + size / 2; i++) {
            segmentTree[i] = Long.parseLong(br.readLine());
        }

        for (int i = size / 2 - 1; i > 0; i--) {
            segmentTree[i] = ((segmentTree[i * 2] % 1000000007) * (segmentTree[i * 2 + 1] % 1000000007)) % 1000000007;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + c; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                change(b, c);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(mul(b, c)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void change(int index, long value) {
        index += (int) (Math.pow(2, k) - 1);

        segmentTree[index] = value;
        index /= 2;
        while(index > 0) {
            segmentTree[index] = ((segmentTree[index * 2] % 1000000007) * (segmentTree[index * 2 + 1] % 1000000007)) % 1000000007;
            index /= 2;
        }
    }

    static long mul(int startIdx, int endIdx) {
        startIdx += (int) (Math.pow(2, k) - 1);
        endIdx += (int) (Math.pow(2, k) - 1);

        long result = 1;
        while (startIdx <= endIdx) {
            if (startIdx % 2 == 1) {
                result = result * segmentTree[startIdx] % 1000000007;
            }
            if (endIdx % 2 == 0) {
                result = result * segmentTree[endIdx] % 1000000007;
            }

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return result % 1000000007;
    }
}