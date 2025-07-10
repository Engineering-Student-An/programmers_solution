import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visit = new boolean[10000];

            bfs();
        }

        System.out.print(sb);
    }

    static void bfs() {
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.command.length(), o2.command.length()));
        queue.add(new Info(n, ""));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            // D
            int temp = (now.n * 2) % 10000;
            if(temp == m) {
                sb.append(now.command).append("D").append("\n");
                return;
            }
            if(!visit[temp]) {
                queue.add(new Info(temp, now.command + "D"));
                visit[temp] = true;
            }

            // S
            temp = (now.n == 0) ? 9999 : now.n - 1;
            if(temp == m) {
                sb.append(now.command).append("S").append("\n");
                return;
            }
            if(!visit[temp]) {
                queue.add(new Info(temp, now.command + "S"));
                visit[temp] = true;
            }

            // L
            int d4 = now.n % 10;
            int d3 = (now.n / 10) % 10;
            int d2 = (now.n / 100) % 10;
            int d1 = now.n / 1000;
            temp = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
            if(temp == m) {
                sb.append(now.command).append("L").append("\n");
                return;
            }
            if(!visit[temp]) {
                queue.add(new Info(temp, now.command + "L"));
                visit[temp] = true;
            }

            // R
            temp = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
            if(temp == m) {
                sb.append(now.command).append("R").append("\n");
                return;
            }
            if(!visit[temp]) {
                queue.add(new Info(temp, now.command + "R"));
                visit[temp] = true;
            }
        }
    }

    static class Info {
        int n;
        String command;

        public Info(int n, String command) {
            this.n = n;
            this.command = command;
        }
    }
}