import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, remove;
    static ArrayList<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < n; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n != -1) {
                adjacencyList[n].add(i);
            } else {
                root = i;
            }
        }

        remove = Integer.parseInt(br.readLine());

        System.out.println(bfs(root));
    }

    static int bfs(int num) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        if(num == remove) return 0;

        int result = 0;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            boolean check = false;
            for(Integer i : adjacencyList[now]) {
                if(i != remove) {
                    queue.add(i);
                    check = true;
                }
            }

            if(!check) result ++;
        }

        return result;
    }
}