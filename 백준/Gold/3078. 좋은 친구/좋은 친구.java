import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        // 초기화
        int[] check = new int[21];
        for (int i = 0; i <= k; i++) {
            check[arr[i].length()] ++;
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            int now = arr[i].length();

            if(i != 0) {
                check[arr[i - 1].length()]--;
                if (i + k < n) check[arr[i + k].length()]++;
            }

            result += (check[now] <= 0) ? 0 : check[now] - 1;
        }

        System.out.println(result);
    }
}