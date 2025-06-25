import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        long[] arr = new long[n+1];
        long max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(num[i] > num[j]) arr[i] = Math.max(arr[i], arr[j] + 1);
            }

            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }
}