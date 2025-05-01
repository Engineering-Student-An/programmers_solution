import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] left = new long[n+2];
        long[] right = new long[n+2];
        for (int i = 1; i <= n; i++) {
            left[i] = Math.max(arr[i], left[i-1] + arr[i]);
        }
        for (int i = n; i > 0; i--) {
            right[i] = Math.max(arr[i], right[i+1] + arr[i]);
        }

        long max = Integer.MIN_VALUE;
        for (int i = 2; i < n; i++) {
            max = Math.max(max, left[i-1] + right[i+1]);
        }
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, left[i]);
        }
        System.out.println(max);
    }
}