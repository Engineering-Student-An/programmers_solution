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
        int e = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[e];
        long[] result = new long[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, value);
        }

        // 벨만-포드
        result[1] = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < e; j++) {
                if(result[edges[j].start] != Integer.MAX_VALUE &&
                        result[edges[j].end] > result[edges[j].start] + edges[j].value) {
                    result[edges[j].end] = result[edges[j].start] + edges[j].value;
                }
            }
        }

        // 음수 사이클 여부 체크
        boolean minusCheck = false;
        for (int j = 0; j < e; j++) {
            if(result[edges[j].start] != Integer.MAX_VALUE &&
                    result[edges[j].end] > result[edges[j].start] + edges[j].value) {
                minusCheck = true;
            }
        }

        if(minusCheck) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                System.out.println((result[i] != Integer.MAX_VALUE) ? result[i] : -1);
            }
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