import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PriorityQueue<Integer> q = new PriorityQueue<>(new QComparator());

        for (int i = 0; i < n*n; i++) {
            q.add(scanner.nextInt());
        }

        int result = -1;

        for (int i = 0; i < n; i++) {
            result = q.poll();
        }

        System.out.println(result);
    }

    static class QComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

}