import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);

        System.out.println((visit[end] == Integer.MAX_VALUE) ? -1 : visit[end]);
    }

    static void bfs(int start, int end) {
        visit = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            visit[i] = Integer.MAX_VALUE;
        }

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(start, 0));
        while (!queue.isEmpty()) {
            Info now = queue.poll();


            for (int i = 1; now.index + (i * arr[now.index]) <= n; i++) {
                if(visit[now.index + (i * arr[now.index])] > now.count + 1) {
                    visit[now.index + (i * arr[now.index])] = now.count + 1;
                    queue.add(new Info(now.index + (i * arr[now.index]), visit[now.index + (i * arr[now.index])]));
                }
            }

            for (int i = -1; now.index + (i * arr[now.index]) >= 1; i--) {
                if(visit[now.index + (i * arr[now.index])] > now.count + 1) {
                    visit[now.index + (i * arr[now.index])] = now.count + 1;
                    queue.add(new Info(now.index + (i * arr[now.index]), visit[now.index + (i * arr[now.index])]));
                }
            }
        }
    }

    static class Info {
        int index;
        int count;

        public Info(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}