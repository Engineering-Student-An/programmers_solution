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
        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        int middle;
        while(left <= right) {
            middle = (left + right) / 2;

            if(isPossible(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        System.out.println(left);
    }

    static boolean isPossible(int num) {

        int sum = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if(sum + arr[i] > num) {
                sum = 0;
                count ++;
            }

            sum += arr[i];
        }

        return (count <= m);
    }
}