import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        long ans = 0;
        while (queue.size() >= 3) {
            ans += queue.poll();
            ans += queue.poll();

            queue.poll();
        }

        while (!queue.isEmpty()) {
            ans += queue.poll();
        }

        System.out.println(ans);
    }
}