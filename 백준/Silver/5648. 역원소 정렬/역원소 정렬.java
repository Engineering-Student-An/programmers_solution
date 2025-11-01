import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            long num = scanner.nextLong();
            queue.add(convert(num));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append("\n");
        }

        System.out.print(sb);
    }

    static long convert(long num) {

        long result = 0;

        while(true) {
            result += (num % 10);
            num /= 10;

            if(num == 0) break;

            result *= 10;
        }
        return result;
    }
}