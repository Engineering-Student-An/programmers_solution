import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int f, s, g, u, d;
    static long[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new long[f+1];
        for (int i = 0; i <= f; i++) {
            arr[i] = Long.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        arr[s] = 0;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            if(now + u <= f && arr[now + u] == Long.MAX_VALUE) {
                arr[now + u] = arr[now] + 1;
                queue.add(now + u);
            }
            if (now - d >= 1 && arr[now - d] == Long.MAX_VALUE) {
                arr[now - d] = arr[now] + 1;
                queue.add(now - d);
            }

            if(arr[g] != Long.MAX_VALUE) break;
        }

        System.out.println(arr[g] != Long.MAX_VALUE ? arr[g] : "use the stairs");
    }
}