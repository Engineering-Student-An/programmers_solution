import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                queue.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while(queue.size() >= 2) {
                Long first = queue.poll();
                Long second = queue.poll();

                sum += first + second;
                queue.add(first + second);
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}