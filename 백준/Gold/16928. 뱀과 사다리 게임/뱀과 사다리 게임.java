import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[] result = new int[101];
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map.put(u, v);
        }

        bfs();

        System.out.println(result[100]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        for (int i = 2; i <= 100; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (int i = 1; i <= 6; i++) {
                Integer next = now + i;
                if(next <= 100 && map.get(next) == null && result[next] > result[now] + 1) { // 사다리나 뱀이 없는 경우
                    result[next] = result[now] + 1;
                    queue.add(next);
                } else if(next <= 100 && map.get(next) != null) {
                    next = map.get(next);
                    if(result[next] > result[now] + 1) {
                        result[next] = result[now] + 1;
                        queue.add(next);
                    }
                }
            }
        }
    }
}