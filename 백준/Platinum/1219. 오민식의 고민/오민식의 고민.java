import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[e];
        long[] result = new long[n];
        int[] earn = new int[n];
        Arrays.fill(result, Long.MIN_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, value * (-1));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            earn[i] = Integer.parseInt(st.nextToken());
        }

        // 벨만-포드
        result[start] = earn[start];
        for (int i = 0; i <= n + 100; i++) {
            for (int j = 0; j < e; j++) {
                if(result[edges[j].start] == Long.MIN_VALUE) continue;
                else if(result[edges[j].start] == Long.MAX_VALUE) {
                    result[edges[j].end] = Long.MAX_VALUE;
                } else if(result[edges[j].end] < result[edges[j].start] + edges[j].value + earn[edges[j].end]) {
                    result[edges[j].end] = result[edges[j].start] + edges[j].value + earn[edges[j].end];

                    if(i >= n-1) result[edges[j].end] = Long.MAX_VALUE;
                }
            }
        }

        if(result[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if(result[end] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(result[end]);
        }
    }

    static class Edge {
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}