import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int a = Integer.parseInt(br.readLine());
        int first = a;
        int last = 0;
        for (int i = 0; i < n - 1; i++) {
            last = Integer.parseInt(br.readLine());
            queue.add(last - a);
            a = last;
        }

        int gcd = gcd(queue.poll(), queue.poll());
        while (!queue.isEmpty()) {
            gcd = gcd(gcd, queue.poll());
        }
        System.out.println((last - first) / gcd - n  + 1);
    }

    static int gcd(int a, int b) {
        while(b % a > 0) {
            int mod = b % a;
            b = a;
            a = mod;
        }

        return a;
    }
}