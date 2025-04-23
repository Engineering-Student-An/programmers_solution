import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int[] result = new int[2];
        int rSum = Integer.MAX_VALUE;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(Math.abs(rSum) > Math.abs(sum)) {
                rSum = sum;
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if(sum == 0) break;
            if(sum < 0) left ++;
            else right --;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}