import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] arr = new long[10][65];
        for (int i = 0; i < 10; i++) {
            arr[i][1] = 1;
        }

        for (int k = 2; k <= 64; k++) {
            arr[0][k] = 1;
            for (int i = 1; i < 10; i++) {
                arr[i][k] = arr[i-1][k] + arr[i][k-1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            int n = Integer.parseInt(br.readLine());

            long sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += arr[i][n];
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}