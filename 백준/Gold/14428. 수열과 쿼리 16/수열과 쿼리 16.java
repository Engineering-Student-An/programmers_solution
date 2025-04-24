import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, size;
    static int k = 0;
    static Info[] segmentTree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        while(Math.pow(2, k) <= n) {
            k ++;
        }

        size = (int) Math.pow(2, k+1);
        segmentTree = new Info[size];

        st = new StringTokenizer(br.readLine());
        for (int i = size/2; i < size/2 + n; i++) {
            segmentTree[i] = new Info((i-size/2 + 1), Long.parseLong(st.nextToken()));
        }
        for (int i = size/2 + n; i < size; i++) {
            segmentTree[i] = new Info((i - size / 2 + 1), Long.MAX_VALUE);
        }

        for (int i = size/2 - 1; i > 0; i--) {
            segmentTree[i] = (segmentTree[i*2].value <= segmentTree[i*2+1].value)
                    ? new Info(segmentTree[i*2].index, segmentTree[i*2].value)
                    : new Info(segmentTree[i*2+1].index, segmentTree[i*2+1].value);
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a == 1) {
                int index = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                change(index, value);
            } else {
                int startIdx = Integer.parseInt(st.nextToken());
                int endIdx = Integer.parseInt(st.nextToken());
                sb.append(min(startIdx, endIdx)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void change(int index, long value) {
        index += (int) (Math.pow(2, k) - 1);
        segmentTree[index] = new Info((index-size/2 + 1), value);

        index /= 2;
        while(index > 0) {
            segmentTree[index] = (segmentTree[index*2].value <= segmentTree[index*2+1].value)
                    ? new Info(segmentTree[index*2].index, segmentTree[index*2].value)
                    : new Info(segmentTree[index*2+1].index, segmentTree[index*2+1].value);
            index /= 2;
        }
    }

    static int min(int startIdx, int endIdx) {
        startIdx += (int) (Math.pow(2, k) - 1);
        endIdx += (int) (Math.pow(2, k) - 1);

        Info info = new Info(0, Long.MAX_VALUE);
        while (startIdx <= endIdx) {
            if(startIdx % 2 == 1) {
                if((segmentTree[startIdx].value < info.value)
                        || (segmentTree[startIdx].value == info.value && segmentTree[startIdx].index < info.index)) {

                    info.value = segmentTree[startIdx].value;
                    info.index = segmentTree[startIdx].index;
                }
            }
            if(endIdx % 2 == 0) {
                if((segmentTree[endIdx].value < info.value)
                        || (segmentTree[endIdx].value == info.value && segmentTree[endIdx].index < info.index)) {

                    info.value = segmentTree[endIdx].value;
                    info.index = segmentTree[endIdx].index;
                }
            }

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return info.index;
    }

    static class Info {
        int index;
        long value;

        public Info(int index, long value) {
            this.index = index;
            this.value = value;
        }
    }
}