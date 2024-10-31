import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(new QComparator());

        int zero = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if(num < 0) {
                minusQueue.add(num);
            } else if(num > 0) {
                plusQueue.add(num);
            } else {
                zero++;
            }
        }

        long sum = 0;

        while(minusQueue.size() > 1) {
            int a = minusQueue.poll();
            int b = minusQueue.poll();
            sum += a*b;
        }

        if(zero < 1 && minusQueue.size() == 1) {
            sum += minusQueue.poll();
        }

        while(plusQueue.size() > 1) {
            int a = plusQueue.poll();
            int b = plusQueue.poll();
            sum += Math.max(a*b, a+b);
        }
        if(plusQueue.size() == 1) {
            sum += plusQueue.poll();
        }

        System.out.println(sum);
    }

    public static class QComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {

            return o2-o1;
        }
    }
}