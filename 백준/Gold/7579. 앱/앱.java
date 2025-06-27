import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        Info[] arr = new Info[n+1];
        arr[0] = new Info(-1, -1);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = new Info(Long.parseLong(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int wSum = 0;
        for (int i = 1; i <= n; i++) {
            int w = Integer.parseInt(st.nextToken());
            arr[i].w = w;
            wSum += w;
        }

        Arrays.sort(arr, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.w == o2.w) return (int) (o2.v - o1.v);
                return o1.w - o2.w;
            }
        });
        long[][] result = new long[n+1][wSum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= wSum; j++) {
                if(arr[i].w <= j) {
                    result[i][j] = Math.max(result[i-1][j], arr[i].v + result[i-1][j-arr[i].w]);
                } else {
                    result[i][j] = result[i-1][j];
                }
            }
        }

        long min = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= wSum; j++) {
                if(result[i][j] >= m) {
                    min = Math.min(min, j);
                    break;
                }
            }
        }

        System.out.println(min);
    }

    static class Info {
        int w;
        long v;

        public Info(long v) {
            this.v = v;
        }

        public Info(int w, long v) {
            this.w = w;
            this.v = v;
        }
    }
}