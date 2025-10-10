import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = 1;
        while (Math.pow(2, k++) < n) {}
        int m = (int) Math.pow(2, k);

        Info[] segmentTree = new Info[m];
        int b = (int) Math.pow(2, k-1);
        for (int i = b; i < m; i++) {
            if (i < b + n) segmentTree[i] = new Info(arr[i-b], i-b);
            else segmentTree[i] = new Info(Integer.MAX_VALUE, -1);
        }

        for (int i = b - 1; i >= 1; i--) {
            if(segmentTree[i * 2].num <= segmentTree[i * 2 + 1].num) {
                segmentTree[i] = new Info(segmentTree[i * 2].num, segmentTree[i * 2].index);
            } else {
                segmentTree[i] = new Info(segmentTree[i * 2 + 1].num, segmentTree[i * 2 + 1].index);
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a == 2) {
                sb.append((segmentTree[1].index+1)).append("\n");
            } else {
                int i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                segmentTree[b + i - 1].num = v;
                for (int j = (b + i - 1) / 2; j > 0; j /= 2) {
                    if(segmentTree[j * 2].num <= segmentTree[j * 2 + 1].num) {
                        segmentTree[j].num = segmentTree[j * 2].num;
                        segmentTree[j].index = segmentTree[j * 2].index;
                    } else {
                        segmentTree[j].num = segmentTree[j * 2 + 1].num;
                        segmentTree[j].index = segmentTree[j * 2 + 1].index;
                    }
                }
            }
        }

        System.out.print(sb);
    }

    static class Info {
        int num, index;

        public Info(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}