import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+3];
        for (int i = 3; i <= n+2; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[n+3];
        for (int i = 3; i <= n+2 ; i++) {
            result[i] = Math.max(result[i - 1], Math.max(result[i - 3] + arr[i-1] + arr[i], result[i - 2] + arr[i]));
        }

        System.out.println(result[n+2]);
    }
}