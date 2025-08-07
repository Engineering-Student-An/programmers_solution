import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] arr = new long[32][32];
        for (int i = 0; i < 32; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if(j > 0) arr[i][j] += arr[i][j-1];
                if(j < 31) arr[i][j] += arr[i-1][j+1];
            }
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            sb.append(arr[n][0]).append("\n");
        }

        System.out.print(sb);
    }
}