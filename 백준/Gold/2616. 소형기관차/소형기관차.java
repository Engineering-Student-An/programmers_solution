/*
    35 40 50 10 30 45 60
    75 90 60 40 75 105

    0   1   2   3
0   0   75  x   x
1   0   90  x   x
2   0   90  135 x
3   0   90  135 x
4   0   90  165 210
5   0   105 195 240
 */

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
        int k = Integer.parseInt(br.readLine());

        int[] sum = new int[n - k + 1];
        int part = 0;
        for (int i = 0; i < k; i++) part += arr[i];
        sum[0] = part;

        for (int i = 1; i < n - k + 1; i++) {
            part -= arr[i - 1];
            part += arr[i + k - 1];
            sum[i] = part;
        }

        int[][] result = new int[n - k + 1][4];
        result[0][1] = sum[0];
        for (int i = 1; i < k; i++) {
            result[i][1] = Math.max(result[i - 1][1], sum[i]);
        }

        for (int i = k; i < 2 * k; i++) {
            result[i][1] = Math.max(result[i - 1][1], sum[i]);
            result[i][2] = Math.max(result[i - 1][2], result[i - k][1] + sum[i]);
        }

        for (int i = 2 * k; i < n - k + 1; i++) {
            result[i][1] = Math.max(result[i - 1][1], sum[i]);
            result[i][2] = Math.max(result[i - 1][2], result[i - k][1] + sum[i]);
            result[i][3] = Math.max(result[i - 1][3], result[i - k][2] + sum[i]);
        }
        System.out.println(result[n-k][3]);
    }
}