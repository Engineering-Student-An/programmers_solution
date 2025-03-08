import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        if(n == 1) {
            System.out.println(1);
        } else {
            while (true) {
                deque.removeFirst();

                if (deque.size() == 1) break;

                Integer poll = deque.removeFirst();
                deque.addLast(poll);
            }

            System.out.println(deque.getFirst());
        }
    }
}