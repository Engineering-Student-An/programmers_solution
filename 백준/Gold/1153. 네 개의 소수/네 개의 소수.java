import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int[] prime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[1000001];
        prime = new int[78498];

        for (int i = 2; i <= 1000000; i++) {
            isPrime[i] = true;
        }

        int index = 0;
        for (int i = 2; i <= 1000000; i++) {
            if(isPrime[i]) {
                prime[index ++] = i;
                for (int j = i*2; j <= 1000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());

        if(n < 8) System.out.println(-1);
        else {
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            int a = n / 2;
            int b = (n % 2 == 0) ? n / 2 : n / 2 + 1;
            while(a > 0) {
                List<Integer> left = find(a);
                List<Integer> right = find(b);

                if(left.size() == 2 && right.size() == 2) {
                    queue.addAll(left);
                    queue.addAll(right);
                    break;
                }

                a --;
                b ++;
            }
            if(queue.isEmpty()) System.out.println(-1);
            else {
                while (!queue.isEmpty()) {
                    System.out.print(queue.poll() + " ");
                }
            }

        }
    }

    static List<Integer> find(int n) {
        List<Integer> result = new ArrayList<>();

        int left = 0, right = 78497;
        while(left <= right) {
            int a = prime[left];
            int b = prime[right];

            if(a + b == n) {
                result.add(a);
                result.add(b);
                break;
            }

            if(a + b > n) right --;
            else left ++;
        }

        return result;
    }
}