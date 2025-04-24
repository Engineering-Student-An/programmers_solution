import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, size;
    static long[] segmentTree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        k = 0;
        while(Math.pow(2, k) <= n) {
            k ++;
        }

        size = (int) Math.pow(2, k+1);
        segmentTree = new long[size];
        for (int i = size/2; i < size/2 + n; i++) {
            segmentTree[i] = Long.parseLong(br.readLine());
        }

        for (int i = size/2-1; i > 0; i--) {
            segmentTree[i] = Math.min(segmentTree[i * 2], segmentTree[i * 2 + 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());

            sb.append(min(startIdx, endIdx)).append("\n");
        }

        System.out.print(sb);
    }

    static long min(int startIdx, int endIdx) {
        startIdx += (int)(Math.pow(2, k) - 1);
        endIdx += (int)(Math.pow(2, k) - 1);

        long result = Long.MAX_VALUE;
        while(startIdx <= endIdx) {
            if(startIdx % 2 == 1) {
                result = Math.min(segmentTree[startIdx], result);
            }
            if(endIdx % 2 == 0) {
                result = Math.min(segmentTree[endIdx], result);
            }

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return result;
    }
}