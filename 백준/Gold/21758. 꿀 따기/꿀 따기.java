import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] partSum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            partSum[i] = (i == 0) ? arr[i] : partSum[i-1] + arr[i];
        }

        int result = 0;

        // 왼쪽 벌 2, 오른쪽 벌통
        for (int i = 1; i < n - 1; i++) {
            int sum = (partSum[i-1] - partSum[0]) + (partSum[n-1] - partSum[i]) * 2;
            result = Math.max(result, sum);
        }

        // 왼쪽 벌통, 오른쪽 벌 2
        for (int i = n - 2; i >= 1; i--) {
            int sum = (partSum[n-2] - partSum[i]) + partSum[i-1] * 2;
            result = Math.max(result, sum);
        }

        // 왼쪽 벌 1, 중간 벌통, 오른쪽 벌 1
        for (int i = 1; i < n - 1; i++) {
            int sum = (partSum[i] - partSum[0]) + (partSum[n - 2] - partSum[i - 1]);
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}