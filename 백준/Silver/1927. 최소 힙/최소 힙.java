import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            if(t == 0) {
                if(queue.isEmpty()) {
                    sb.append(0);
                    sb.append("\n");
                } else {
                    sb.append(queue.poll());
                    sb.append("\n");
                }
            } else {
                queue.add(t);
            }
        }

        System.out.print(sb);


    }
}