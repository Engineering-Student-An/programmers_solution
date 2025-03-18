import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while (!queue.isEmpty() && queue.size() > 1) {
            Long first = queue.poll();
            result += first;
            if(queue.isEmpty()) break;

            Long second = queue.poll();
            result += second;
            if(queue.isEmpty()) break;

            queue.add(first + second);
        }

        System.out.println(result);
    }
}