import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];
        result[0] = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if(arr[i] > arr[j] && result[i] < result[j] + 1) {
                    result[i] = result[j] + 1;
                }
            }

            if(result[i] == 0) result[i] = 1;
            max = Math.max(max, result[i]);
        }

        System.out.println(n - max);
    }
}