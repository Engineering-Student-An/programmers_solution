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

        arr = new int[m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(find(max));
    }

    static int find(int right) {
        int left = 1;
        while (left <= right) {
            int middle = (left + right) / 2;

            if (isPossible(middle)) {
                right = middle - 1;
            } else left = middle + 1;
        }

        return left;
    }

    static boolean isPossible(int num) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            count += (arr[i] % num > 0) ? arr[i] / num + 1 : arr[i] / num;
            if(count > n) return false;
        }

        return true;
    }
}