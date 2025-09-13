import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] adjSum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        adjSum = new long[1000001];

        getSum();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(adjSum[num]).append("\n");
        }

        System.out.print(sb);
    }

    static void getSum() {

        long[] sum = new long[1000001];
        for (int i = 1; i <= 1000000; i++) {
            for (int j = i; j <= 1000000; j+=i) {
                sum[j] += i;
            }
        }

        for (int i = 1; i <= 1000000; i++) {
            adjSum[i] = adjSum[i-1] + sum[i];
        }
    }
}