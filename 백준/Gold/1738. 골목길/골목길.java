import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Info> edgeList = new ArrayList<>();
    static long[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            edgeList.add(new Info(s, e, value));
        }

        result = new long[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = Long.MIN_VALUE;
        }
        result[1] = 0;

        int[] prev = new int[n + 1]; // 이전 노드 저장
        Arrays.fill(prev, -1);
        for (int i = 0; i < n - 1; i++) {
            for (Info info : edgeList) {
                if(result[info.s] != Long.MIN_VALUE && result[info.e] < result[info.s] + info.value) {
                    result[info.e] = result[info.s] + info.value;
                    prev[info.e] = info.s;
                }
            }
        }

        for (int i = 0; i < 200; i++) {
            for (Info info : edgeList) {
                if(result[info.s] == Long.MAX_VALUE) result[info.e] = Long.MAX_VALUE;

                else if(result[info.s] != Long.MIN_VALUE && result[info.e] < result[info.s] + info.value) {
                    result[info.e] = Long.MAX_VALUE;
                }
            }
        }

        if(result[n] == Long.MAX_VALUE) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();

//            int index = n;
//            List<Integer> route = new ArrayList<>();
//            boolean[] visit = new boolean[n+1];
//            visit[index] = true;
//            while(index != 1) {
//                route.add(index);
//
//                for (Info info : edgeList) {
//                    if(info.e != index) continue;
//
//                    if(result[info.e] == result[info.s] + info.value && !visit[info.s]) {
//                        index = info.s;
//                        visit[info.s] = true;
//                        break;
//                    }
//                }
//            }
//            route.add(1);

            List<Integer> route = new ArrayList<>();
            int cur = n;
            while (cur != -1) {
                route.add(cur);
                cur = prev[cur];
            }
            for (int i = route.size() - 1; i >= 0; i--) {
                sb.append(route.get(i)).append(" ");
            }
            System.out.println(sb);
        }
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