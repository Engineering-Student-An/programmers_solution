import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> prime = new ArrayList<>();
        prime.add(2);
        for (int i = 3; i < 120; i += 2) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) prime.add(i);
        }

        for (int i = 0; i < prime.size() - 1; i++) {
            if(prime.get(i) * prime.get(i + 1) > n) {
                System.out.println(prime.get(i) * prime.get(i + 1));
                break;
            }
        }
    }
}