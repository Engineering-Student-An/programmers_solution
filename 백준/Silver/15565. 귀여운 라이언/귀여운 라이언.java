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

        int[] arr = new int[n];
        int totalK = 0;
        st = new StringTokenizer(br.readLine());

        int left = -1, right = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 1) totalK ++;

            if(left == -1 && totalK == 1) left = i;
            if(right == - 1 && totalK == k) right = i;
        }

        if(totalK < k) {
            System.out.println(-1);
        } else {
            int min = right - left + 1;

            while (left <= n - k) {
                left ++;
                while(left < n && arr[left] == 2) {
                    left ++;
                }

                if(left == n) break;

                right ++;
                while(right < n && arr[right] == 2) {
                    right ++;
                }

                if(right == n) break;

                min = Math.min(min, (right - left + 1));
            }

            System.out.println(min);
        }
    }
}