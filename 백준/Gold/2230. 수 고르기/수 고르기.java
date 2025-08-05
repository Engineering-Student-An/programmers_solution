import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(find());
    }

    static int find() {

        int result = Integer.MAX_VALUE;

        int left = 0;
        int right = 1;

        while(right < n) {
            int diff = arr[right] - arr[left];

            if(diff == m) return m;
            if(diff > m) {
                result = Math.min(result, diff);
                if(right - left == 1) right ++;
                left ++;
            } else {
                right ++;
            }
        }

        return result;
    }
}