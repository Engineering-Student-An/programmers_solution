import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int result = 0;
        boolean checkBefore = false;
        for (int i = 0; i < n; i++) {

            if(i > 0 && arr[i] == arr[i-1] && checkBefore) {
                result ++;
            } else {

                long ans = arr[i];

                int left = 0;
                int right = n - 1;

                boolean checkNow = false;
                while (left < right) {
                    long sum = arr[left] + arr[right];

                    if (left == i) {
                        left++;
                        continue;
                    }
                    else if (right == i) {
                        right--;
                        continue;
                    }

                    if (sum == ans) {
                        result++;
                        checkNow = true;
                        break;
                    } else if (sum > ans) {
                        right--;
                    } else {
                        left++;
                    }
                }

                checkBefore = checkNow;
            }
        }

        System.out.println(result);
    }
}