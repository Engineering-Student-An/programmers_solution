import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        List<Integer> prime = new ArrayList<>();
        prime.add(2);
        int index = -1;
        for (int i = 3; i <= n; i += 2) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                prime.add(i);
                if(index == -1 && i > k) index = prime.indexOf(i);
            }
        }

        if(prime.get(0) > k) index = 0;
        if(index == -1) {
            System.out.println(n);
        } else {
            boolean[] isNotSejun = new boolean[n + 1];
            for (int i = index; i < prime.size(); i++) {
                for (int j = 1; j * prime.get(i) <= n; j++) {
                    isNotSejun[j * prime.get(i)] = true;
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (!isNotSejun[i]) count++;
            }

            System.out.println(count);
        }
    }
}