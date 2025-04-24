import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, size;
    static int k = 0;
    static long[] segmentTree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        while(Math.pow(2, k) <= n) {
            k ++;
        }

        size = (int) Math.pow(2, k+1);
        segmentTree = new long[size];

        st = new StringTokenizer(br.readLine());
        for (int i = size/2; i < size/2 + n; i++) {
            segmentTree[i] = Long.parseLong(st.nextToken());
        }

        for (int i = size/2 - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[i * 2] + segmentTree[i * 2 + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            if(startIdx > endIdx) {
                int temp = startIdx;
                startIdx = endIdx;
                endIdx = temp;
            }
            sb.append(sum(startIdx, endIdx)).append("\n");

            int idx = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            change(idx, value);
        }

        System.out.print(sb);
    }

    static long sum(int startIdx, int endIdx) {
        startIdx += (int) (Math.pow(2, k) - 1);
        endIdx += (int) (Math.pow(2, k) - 1);

        long sum = 0;
        while (startIdx <= endIdx) {
            if(startIdx % 2 == 1) sum += segmentTree[startIdx];
            if(endIdx % 2 == 0) sum += segmentTree[endIdx];

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return sum;
    }

    static void change(int index, long value) {
        index += (int) (Math.pow(2, k) - 1);

        long diff = value - segmentTree[index];

        segmentTree[index] = value;
        index /= 2;

        while(index > 0) {
            segmentTree[index] += diff;
            index /= 2;
        }
    }
}