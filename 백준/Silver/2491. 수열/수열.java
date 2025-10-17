import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 1;
        // 증가
        int left = 0, right = 1, count = 1;
        while(right < n) {
            if(arr[right] < arr[right - 1]) {
                max = Math.max(max, count);
                count = 1;
                left = right;
                right = left + 1;

            } else {
                right ++;
                count ++;
            }
        }
        max = Math.max(max, count);

        // 감소
        left = 0; right = 1; count = 1;
        while(right < n) {
            if(arr[right] > arr[right - 1]) {
                max = Math.max(max, count);
                count = 1;
                left = right;
                right = left + 1;
            } else {
                right ++;
                count ++;
            }
        }
        max = Math.max(max, count);
        System.out.println(max);
    }
}