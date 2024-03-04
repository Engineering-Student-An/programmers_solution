import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        int ans = 0;

        if(queue.size() > 1) {

            while (queue.size() > 1) {
                int a = queue.poll();
                int b = queue.poll();
                int temp = a + b;
                ans += temp;
                queue.add(temp);
            }
        }

        System.out.println(ans);
    }
}