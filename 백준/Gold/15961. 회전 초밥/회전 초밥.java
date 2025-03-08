import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + k - 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n ; i < n + k - 1; i++) {
            arr[i] = arr[i - n];
        }

        int[] dish = new int[d + 1];
        int count = 0;
        for (int i = 0; i < k; i++) {
            int now = arr[i];
            dish[now] ++;
            if(dish[now] == 1) count ++;
        }

        int result = (dish[c] >= 1) ? count : count + 1;

        int left = 0;
        int right = k-1;
        while(true) {

            if(right >= n + k - 2) break;

            dish[arr[left]] --;
            if(dish[arr[left]] == 0) count --;
            left ++;
            right ++;
            dish[arr[right]] ++;
            if(dish[arr[right]] == 1) count ++;

            int now = (dish[c] >= 1) ? count : count + 1;

            result = Math.max(result, now);
        }
        System.out.println(result);
    }
}