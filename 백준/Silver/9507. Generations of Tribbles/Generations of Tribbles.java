import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[68];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i <= 67; i++) {
            arr[i] = arr[i - 4] + arr[i - 3] + arr[i - 2] + arr[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append("\n");
        }

        System.out.print(sb);
    }
}