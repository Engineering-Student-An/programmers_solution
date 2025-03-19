import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> plus = new PriorityQueue<>(new PlusComparator());
        PriorityQueue<Long> minus = new PriorityQueue<>();
        int zero =  0;
        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());

            if(num > 0) plus.add(num);
            else if(num == 0) zero ++;
            else minus.add(num);
        }

        long result = 0;
        while (!plus.isEmpty()) {
            Long one = plus.poll();
            if (plus.isEmpty()) {
                result += one;
                break;
            } else if(one == 1) {
                result += one;
                continue;
            }

            Long two = plus.poll();
            if(two == 1) {
                result += one + two;
            } else {
                result += (one * two);
            }
        }

        while (!minus.isEmpty()) {
            Long one = minus.poll();
            if (minus.isEmpty()) {
                if(zero > 0) {
                    zero --;
                } else {
                    result += one;
                }
                break;
            }

            Long two = minus.poll();
            result += (one * two);
        }

        System.out.println(result);
    }

    static class PlusComparator implements Comparator<Long> {
        @Override
        public int compare(Long o1, Long o2) {
            return (o2 > o1) ? 1 : -1;
        }
    }
}