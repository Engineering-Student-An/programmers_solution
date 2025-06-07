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

        int[] result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] = Math.max(result[i-j] + arr[j], result[i]);
            }
        }

        System.out.println(result[n]);
    }
}