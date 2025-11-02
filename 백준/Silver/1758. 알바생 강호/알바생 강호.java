import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long ans = 0;
        int count = 1;
        while (!queue.isEmpty()) {
            long tip = queue.poll();

            if(tip - (count - 1) > 0) ans += tip - (count - 1);
            count ++;
        }

        System.out.println(ans);
    }
}