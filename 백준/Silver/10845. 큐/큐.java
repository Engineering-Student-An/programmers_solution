import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        Deque<Integer> deque = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String d = scanner.next();
            if(d.equals("push")) {
                int num = scanner.nextInt();
                deque.addLast(num);
            } else if(d.equals("pop")) {
                if(!deque.isEmpty()) {
                    Integer pop = deque.pop();
                    sb.append(pop).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if(d.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if(d.equals("empty")) {
                sb.append((deque.isEmpty()) ? 1 : 0).append("\n");
            } else if(d.equals("front")) {
                sb.append((deque.isEmpty()) ? -1 : deque.getFirst()).append("\n");
            } else if(d.equals("back")) {
                sb.append((deque.isEmpty()) ? -1 : deque.getLast()).append("\n");
            }


        }

        System.out.print(sb);
    }
}