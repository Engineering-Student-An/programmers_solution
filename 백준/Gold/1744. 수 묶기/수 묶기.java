import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        PriorityQueue<Integer> negative = new PriorityQueue<>();
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        int zero = 0;

        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();

            if(temp < 0) negative.add(temp);
            else if(temp == 0) zero ++;
            else positive.add(temp);
        }

        int ans = 0;
        while(negative.size() > 1) {
            int a = negative.poll();
            int b = negative.poll();

            ans += (a*b);
        }

        if(zero < 1 && negative.size() == 1) {
            ans += negative.poll();
        }

        while(positive.size() > 1) {
            int a = positive.poll();
            int b = positive.poll();
            ans += Math.max(a * b, a + b);
        }
        if(positive.size() == 1) {
            ans += positive.poll();
        }

        System.out.println(ans);
    }
}