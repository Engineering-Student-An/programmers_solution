import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] result = new long[21][n];

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result[arr[0]][0] = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                int plus = j + arr[i];
                int min = j - arr[i];
                if(plus <= 20) result[plus][i] += result[j][i-1];
                if(min >= 0) result[min][i] += result[j][i-1];
            }
        }

        System.out.println(result[arr[n-1]][n-2]);
    }
}