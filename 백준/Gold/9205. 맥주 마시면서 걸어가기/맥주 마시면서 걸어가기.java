import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T -- > 0) {
            int n = Integer.parseInt(br.readLine());
            n += 2;
            Info[] arr = new Info[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            boolean[] visit = new boolean[n];
            visit[0] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            boolean isPossible = false;
            while (!queue.isEmpty()) {
                Integer now = queue.poll();

                if(now == n-1) {
                    isPossible = true;
                    break;
                }

                for (int i = 0; i < n; i++) {
                    if(Math.abs(arr[now].r - arr[i].r) + Math.abs(arr[now].c - arr[i].c) <= 1000 && !visit[i]) {
                        visit[i] = true;
                        queue.add(i);
                    }
                }
            }

            System.out.println(isPossible ? "happy" : "sad");
        }
    }

    static class Info {
        int r, c;

        public Info (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}