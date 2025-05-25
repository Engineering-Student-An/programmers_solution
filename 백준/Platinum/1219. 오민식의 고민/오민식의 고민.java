import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static Info[] edgeList;
    static ArrayList<Integer>[] adjacencyList;
    static long[] result;
    static long[] plusList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edgeList = new Info[m];
        adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edgeList[i] = new Info(s, e, v * -1);
            adjacencyList[s].add(e);
        }

        plusList = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            plusList[i] = Long.parseLong(st.nextToken());
        }

        result = new long[n];
        for (int i = 0; i < n; i++) {
            result[i] = Long.MIN_VALUE;
        }

        if(bellmanFord(start, end)) {
            System.out.println("Gee");
        } else {
            System.out.println( (result[end] != Long.MIN_VALUE) ? result[end] : "gg");
        }

    }

    static boolean bellmanFord(int start, int end) {
        result[start] = plusList[start];

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                Info now = edgeList[j];
                if(result[now.s] != Long.MIN_VALUE && result[now.e] < result[now.s] + now.value + plusList[now.e]) {
                    result[now.e] = result[now.s] + now.value + plusList[now.e];
                }
            }
        }

        if(result[end] == Long.MIN_VALUE) return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Info now = edgeList[j];
                if(result[now.s] != Long.MIN_VALUE && result[now.e] < result[now.s] + now.value + plusList[now.e]) {
                    if(checkIsPossibleToReachEnd(now.e, end)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean checkIsPossibleToReachEnd(int from, int end) {
        boolean[] visit = new boolean[n];
        visit[from] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Integer i : adjacencyList[now]) {
                if(!visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }

        return visit[end];
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