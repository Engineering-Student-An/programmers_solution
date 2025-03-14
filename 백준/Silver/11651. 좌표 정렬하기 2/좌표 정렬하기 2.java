import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            sb.append(poll.x).append(" ").append(poll.y).append("\n");
        }

        System.out.print(sb);
    }

    static class Info implements Comparable<Info>{
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Info o) {
            if(this.y == o.y) {
                return this.x - o.x;
            }

            return this.y - o.y;
        }
    }
}