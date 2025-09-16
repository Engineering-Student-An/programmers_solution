import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[101];
        for (int i = 1; i <= 3; i++) {
            arr[i] = i;
        }

        for (int i = 4; i <= 100; i++) {
            arr[i] = i;
            for (int j = i - 3; j >= 0; j--) {
                arr[i] = Math.max(arr[i], arr[j] * (i - j - 1));
            }
        }

        System.out.println(arr[n]);
    }
}