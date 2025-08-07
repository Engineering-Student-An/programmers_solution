import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int left = -1;
        int right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        while(left < right) {
            int middle = (left + right) / 2;

            if(isPossible(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        System.out.println(left);
    }

    static boolean isPossible(int k) {
        int count = 1;
        int balance = k - arr[0];

        for (int i = 1; i < n; i++) {
            if(balance >= arr[i]) {
                balance -= arr[i];
            } else {
                balance = k - arr[i];
                count ++;
            }

            if(count > m) return false;
        }

        return true;
    }
}