import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] adjacentList;
    static boolean isDone = false;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacentList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacentList[u].add(v);
            adjacentList[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            boolean[] check = new boolean[n];
            check[i] = true;

            if(isDone) break;
            friends(check, i, 1);
        }

        System.out.print( (isDone ? 1: 0));
    }

    private static void friends(boolean[] check, int now, int cnt) {
        check[now] = true;
        if(isDone) {
            return;
        }

        if(cnt == 5) {
            isDone = true;
            return;
        }

        for (Integer i : adjacentList[now]) {
            if(!check[i]) {
                friends(check, i, cnt+1);
            }
        }

        check[now] = false;
    }
}