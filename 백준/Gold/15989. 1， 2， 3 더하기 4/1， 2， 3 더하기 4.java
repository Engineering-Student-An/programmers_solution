import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] result = new long[10001];
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        for (int i = 4; i <= 10000; i++) {
            if(i % 2 == 0) result[i] = result[i - 1] + (result[i - 2] - result[i - 3]);
            else result[i] = result[i - 1] + (result[i - 3] - result[i - 4]);
            if(i % 6 == 0) result[i] ++;
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(result[n]).append("\n");
        }

        System.out.print(sb);
    }
}