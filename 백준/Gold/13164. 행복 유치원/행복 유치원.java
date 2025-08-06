import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] diff = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i+1] - arr[i];
        }

        long result = 0;
        Arrays.sort(diff);
        for (int i = 0; i < n - m; i++) {
            result += diff[i];
        }

        System.out.println(result);
    }
}