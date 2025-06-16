import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, total;
    static int result = Integer.MAX_VALUE;
    static int[] arr;
    static boolean[] visit;
    static List<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                adjacencyList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        visit = new boolean[n+1];
        visit[1] = true;
        combination(1);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void combination(int num) {

        if(num == n) {
            check();
            return;
        }

        visit[num + 1] = true;
        combination(num + 1);
        visit[num + 1] = false;
        combination(num + 1);
    }


    static void check() {

        boolean[] checkVisit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        checkVisit[1] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : adjacencyList[now]) {
                if(visit[next] && !checkVisit[next]) {
                    checkVisit[next] = true;
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(visit[i] && !checkVisit[i]) return;
        }

        if(checkPartial()) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if(visit[i]) sum += arr[i];
            }

            int now = Math.abs(total - 2 * sum);
            result = Math.min(result, now);
        }
    }

    static boolean checkPartial() {

        int index = 0;
        boolean[] checkVisit = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            checkVisit[i] = visit[i];
            if(!visit[i]) {
                index = i;
            }
        }

        if(index == 0) return false;

        checkVisit[index] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer i : adjacencyList[now]) {
                if(!checkVisit[i]) {
                    queue.add(i);
                    checkVisit[i] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(!checkVisit[i]) return false;
        }
        return true;
    }
}