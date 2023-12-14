import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int first = scanner.nextInt();
        for (int i = 0; i < n-1; i++) {
            queue.add(scanner.nextInt());
        }
        int count = 0;

        while(!queue.isEmpty()){
            if (first > queue.peek()) {
                break;
            }
            int x = queue.poll();
            first++;
            x--;
            count++;
            queue.add(x);

        }
        System.out.println(count);

    }
}