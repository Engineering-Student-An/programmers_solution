import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] fibo = new int[41];
        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i <= 40; i++) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }

        int k = Integer.parseInt(br.readLine());
        int start = 0;
        long sum = 1;
        for (int i = 0; i < k; i++) {
            int end = Integer.parseInt(br.readLine());
            sum *= fibo[end - start - 1];
            start = end;
        }

        if(start < n) {
            sum *= fibo[n - start];
        }

        System.out.println(sum);
    }
}