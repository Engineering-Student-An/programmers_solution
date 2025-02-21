import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] segmentTree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long k = 0;
        for (int i = 0; i <= 20; i++) {
            if(Math.pow(2, i) >= n) {
                k = i;
                break;
            }
        }
        long fullIndex = (long) Math.pow(2, k) * 2;
        long dataStartIndex = (long) Math.pow(2, k);
        long dataInsert = dataStartIndex;

        segmentTree = new long[(int) fullIndex];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            segmentTree[(int) dataInsert ++] = Long.parseLong(st.nextToken());
        }

        for (int i = (int) (dataStartIndex - 1); i > 0; i--) {
            segmentTree[i] = segmentTree[i*2] + segmentTree[i*2 + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                change(b, c, dataStartIndex);
            } else if(a == 2) {
                sb.append(partSum(b, (int) c, dataStartIndex)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void change(int b, long c, long dataStartIndex) {

        int targetIndex = (int) (b + dataStartIndex - 1);
        long difference = c - segmentTree[targetIndex];

        while(targetIndex > 0) {
            segmentTree[targetIndex] += difference;
            targetIndex /= 2;
        }
    }

    static long partSum(int startIndex, int endIndex, long dataStartIndex) {

        startIndex = Math.toIntExact(startIndex + dataStartIndex - 1);
        endIndex = Math.toIntExact(endIndex + dataStartIndex - 1);

        long result = 0;
        while(startIndex <= endIndex) {
            if(startIndex % 2 == 1) result += segmentTree[startIndex];
            if(endIndex % 2 == 0) result += segmentTree[endIndex];

            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }

        return result;
    }


}