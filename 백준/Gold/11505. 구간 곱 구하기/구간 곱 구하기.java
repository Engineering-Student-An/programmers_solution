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
        int s = Integer.parseInt(st.nextToken());

        int k = 0;
        while (Math.pow(2, k) < n) {
            k++;
        }

        int fullIndex = (int) (Math.pow(2, k) * 2);
        int dataStartIndex = (int) Math.pow(2, k);
        int temp = dataStartIndex;
        segmentTree = new long[fullIndex];

        for (int i = 0; i < n; i++) {
            segmentTree[temp++] = Long.parseLong(br.readLine());
        }

        for (int i = dataStartIndex-1; i > 0; i--) {
            segmentTree[i] = (segmentTree[i*2] % 1000000007) * (segmentTree[i*2 + 1] % 1000000007) % 1000000007;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                change(b, c, dataStartIndex);
            } else if (a == 2) {
                sb.append(partMul(b, (int) c, dataStartIndex)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static long partMul(int b, int c, int dataStartIndex) {

        b = b + dataStartIndex - 1;
        c = c + dataStartIndex - 1;

        long result = 1;
        while(b <= c) {
            if(b % 2 == 1) {
                result = result * (segmentTree[b]) % 1000000007;
            }
            if(c % 2 == 0) {
                result = result * (segmentTree[c]) % 1000000007;
            }

            b = (b + 1) / 2;
            c = (c - 1) / 2;
        }

        return result;
    }

    static void change(int targetIndex, long c, int dataStartIndex) {

        targetIndex = targetIndex + dataStartIndex - 1;
        segmentTree[targetIndex] = c;
        targetIndex /= 2;

        while(targetIndex > 0) {
            segmentTree[targetIndex] = (segmentTree[targetIndex*2] % 1000000007) * (segmentTree[targetIndex*2 + 1] % 1000000007) % 1000000007;
            targetIndex /= 2;
        }
    }
}