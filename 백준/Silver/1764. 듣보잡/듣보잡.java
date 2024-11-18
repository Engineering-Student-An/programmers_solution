import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        PriorityQueue<String> q1 = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q1.add(scanner.next());
        }

        PriorityQueue<String> q2 = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            q2.add(scanner.next());
        }


        PriorityQueue<String> result = new PriorityQueue<>();
        while(!q1.isEmpty() && !q2.isEmpty()) {
            String one = q1.peek();
            String two = q2.peek();

            if(one.equals(two)) {
                result.add(one);
                q1.poll();
                q2.poll();
            } else if(one.compareTo(two) < 0) {
                q1.poll();
            } else {
                q2.poll();
            }
        }

        System.out.println(result.size());
        for (String string : result) {
            System.out.println(string);
        }
    }
}