import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        boolean[] isNot = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            if(!isNot[i]) {
                for (int j = 2 * i; j <= n; j+=i) {
                    isNot[j] = true;
                }
            }
        }

        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(!isNot[i]) prime.add(i);
        }

        int size = prime.size();
        if(size == 0) System.out.println(0);
        else {
            int count = 0;

            int l = 0, r = 0;
            long sum = prime.get(0);
            while (true) {
                if (sum == n) {
                    count++;
                    if (r == size - 1) break;
                    sum += prime.get(++r);
                } else if (sum < n) {
                    if (r == size - 1) break;
                    sum += prime.get(++r);
                } else {
                    if (l == size - 1) break;
                    sum -= prime.get(l++);
                }
            }

            System.out.println(count);
        }
    }
}