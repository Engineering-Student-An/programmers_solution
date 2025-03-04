import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] sumA = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sumA[i] = sumA[i-1] + a[i];
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m + 1];
        int[] sumB = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            sumB[i] = sumB[i-1] + b[i];
        }

        int[] combA = new int[(n * (n+1)) / 2];
        int[] combB = new int[(m * (m+1)) / 2];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n+1; j++) {
                combA[index ++] = sumA[j] - sumA[i];
            }
        }

        index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m+1; j++) {
                combB[index ++] = sumB[j] - sumB[i];
            }
        }

        Arrays.sort(combA);
        Arrays.sort(combB);

        int left = 0;
        int right = combB.length - 1;

        long result = 0;
        while (left < combA.length && right >= 0) {

            int sum = combA[left] + combB[right];

            if (sum == t) {
                long countA = 0;
                long countB = 0;

                int tempA = combA[left];
                int tempB = combB[right];
                while (left < combA.length && combA[left] == tempA) {
                    countA++;
                    left++;
                }
                while (right >= 0 && combB[right] == tempB) {
                    countB++;
                    right--;
                }

                result += countA * countB;
            } else if (sum > t) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result);
    }

}