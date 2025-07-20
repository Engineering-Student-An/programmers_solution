import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i+1; j < n; j++) {
                    result += gcd(arr[i], arr[j]);
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static long gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(b > 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }
}