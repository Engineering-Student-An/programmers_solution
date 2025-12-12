import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int count = 0;

            while (n != 6174) {
                int next = max(n) - min(n);
                count++;

                n = next;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static int max(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        for (int i = 0; i < 4; i++) {
            queue.add(n % 10);
            n /= 10;
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = result * 10 + queue.poll();
        }

        return result;
    }

    static int min(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < 4; i++) {
            queue.add(n % 10);
            n /= 10;
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = result * 10 + queue.poll();
        }

        return result;
    }
}