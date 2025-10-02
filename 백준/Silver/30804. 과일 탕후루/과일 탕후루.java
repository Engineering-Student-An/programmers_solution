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

        int max = -1;
        int[] type = new int[10];

        int left = 0, right = 0;
        type[arr[0]] = 1;
        while (left <= n -1 && right <= n - 1) {

            int count = 0;

            for (int i = 1; i < 10; i++) {
                if(type[i] > 0) {
                    count ++;
                }
            }

            if (count > 2) {
                type[arr[left]] --;
                left ++;
                if(left == n) break;
            } else {
                max = Math.max((right - left + 1), max);

                right++;
                if(right == n) break;
                type[arr[right]]++;
            }
        }

        System.out.println(max);

    }
}