import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] left = new long[n];
        long[] right = new long[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i-1] + arr[i]);
        }

        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i+1] + arr[i]);
        }

        long result = left[0];
        for (int i = 0; i < n; i++) {
            result = Math.max(result, Math.max(left[i], right[i]));
        }

        for (int i = 1; i < n-1; i++) {
            result = Math.max(result, left[i-1] + right[i+1]);
        }

        System.out.println(result);
    }
}