import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, w;
    static Info[] edgeList;
    static long[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edgeList = new Info[2 * m + w];
            int index = 0;
            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());

                if(i < m) {
                    edgeList[index ++] = new Info(s, e, value);
                    edgeList[index ++] = new Info(e, s, value);
                }
                if(i>=m) {
                    value *= -1;
                    edgeList[index ++] = new Info(s, e, value);
                }
            }

            sb.append((bellmanFord()) ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }

    static boolean bellmanFord() {
        result = new long[n+1];
        for (int j = 2; j <= n; j++) {
            result[j] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < edgeList.length; j++) {
                Info now = edgeList[j];
                if(result[now.e] > result[now.s] + now.value) {
                    result[now.e] = result[now.s] + now.value;
                }
            }
        }

        for (int j = 0; j < edgeList.length; j++) {
            Info now = edgeList[j];
            if(result[now.e] > result[now.s] + now.value) {
                return true;
            }
        }

        return false;
    }

    static class Info {
        int s;
        int e;
        long value;

        public Info(int s, int e, long value) {
            this.s = s;
            this.e = e;
            this.value = value;
        }
    }
}