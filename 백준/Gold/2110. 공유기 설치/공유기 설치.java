import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        Arrays.sort(arr);

        int left = 0;
        int right = max - min;

        int middle;
        while(left <= right) {
            middle = (left + right) / 2;

            if(isPossible(middle)) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println(result);
    }

    static boolean isPossible(int num) {

        int limit = arr[0] + num;
        int count = 1;
        int before = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i] > limit) {
                count ++;
                limit = arr[i] + num;
                distance = Math.min(distance, arr[i] - arr[before]);
                before = i;
            }
        }

        if(count >= m) {
            result = Math.max(result, distance);
            return true;
        }
        else return false;
    }
}