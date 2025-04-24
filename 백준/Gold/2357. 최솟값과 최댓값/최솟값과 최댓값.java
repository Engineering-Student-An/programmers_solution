import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, size;
    static int k = 0;
    static long[] minSegmentTree;
    static long[] maxSegmentTree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        while(Math.pow(2, k) <= n) {
            k ++;
        }

        size = (int) Math.pow(2, k+1);
        minSegmentTree = new long[size];
        maxSegmentTree = new long[size];

        for (int i = size/2; i < size/2 + n; i++) {
            minSegmentTree[i] = Long.parseLong(br.readLine());
            maxSegmentTree[i] = minSegmentTree[i];
        }

        for (int i = size/2 - 1; i > 0; i--) {
            minSegmentTree[i] = Math.min(minSegmentTree[i * 2], minSegmentTree[i * 2 + 1]);
            maxSegmentTree[i] = Math.max(maxSegmentTree[i * 2], maxSegmentTree[i * 2 + 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());

            sb.append(min(startIdx, endIdx)).append(" ").append(max(startIdx, endIdx)).append("\n");
        }

        System.out.print(sb);
    }

    static long min(int startIdx, int endIdx) {
        startIdx += (int) (Math.pow(2, k) - 1);
        endIdx += (int) (Math.pow(2, k) - 1);

        long result = Long.MAX_VALUE;
        while (startIdx <= endIdx) {
            if(startIdx % 2 == 1) {
                result = Math.min(result, minSegmentTree[startIdx]);
            }
            if(endIdx % 2 == 0) {
                result = Math.min(result, minSegmentTree[endIdx]);
            }

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return result;
    }

    static long max(int startIdx, int endIdx) {
        startIdx += (int) (Math.pow(2, k) - 1);
        endIdx += (int) (Math.pow(2, k) - 1);

        long result = -1;
        while (startIdx <= endIdx) {
            if(startIdx % 2 == 1) {
                result = Math.max(result, maxSegmentTree[startIdx]);
            }
            if(endIdx % 2 == 0) {
                result = Math.max(result, maxSegmentTree[endIdx]);
            }

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return result;
    }
}