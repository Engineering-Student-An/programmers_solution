import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] segmentTree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int k = 0;
        while(true) {
            if(Math.pow(2, k) >= n) {
                break;
            }
            k ++;
        }
        
        int fullIndex = (int) (Math.pow(2, k) * 2);
        int dataStartIndex = (int) Math.pow(2, k);
        int temp = dataStartIndex;
        
        segmentTree = new long[fullIndex];
        for (int i = 0; i < n; i++) {
            segmentTree[temp ++] = Long.parseLong(br.readLine());
        }
        for (int i = temp; i < fullIndex; i++) {
            segmentTree[i] = Integer.MAX_VALUE;
        }
        
        for (int i = dataStartIndex - 1; i > 0; i--) {
            segmentTree[i] = Math.min(segmentTree[i * 2], segmentTree[i * 2 + 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            sb.append(minValue(startIndex, endIndex, dataStartIndex)).append("\n");
        }

        System.out.print(sb);
    }

    static long minValue(int startIndex, int endIndex, int dataStartIndex) {

        startIndex = startIndex + dataStartIndex - 1;
        endIndex = endIndex + dataStartIndex - 1;

        long result = Integer.MAX_VALUE;
        while (startIndex <= endIndex) {
            if(startIndex % 2 == 1) result = Math.min(result, segmentTree[startIndex]);
            if(endIndex % 2 == 0) result = Math.min(result, segmentTree[endIndex]);

            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }

        return result;
    }
}