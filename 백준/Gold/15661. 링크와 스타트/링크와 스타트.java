import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, result = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] pick;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k <= n/2; k++) {
            pick = new int[k];
            for (int i = 0; i < n - k + 1; i++) {
                pick[0] = i;
                find(k, i, 1);
            }
        }

        System.out.println(result);
    }

    static void find(int k, int ind, int count) {
        if (k == count) {
            int pickSum = calc(pick);

            int[] noPick = new int[n - k];
            int pickIndex = 0;
            int noPickIndex = 0;
            for (int i = 0; i < n; i++) {
                if(pickIndex < k && pick[pickIndex] == i) pickIndex ++;
                else noPick[noPickIndex ++] = i;
            }

            int noPickSum = calc(noPick);

            result = Math.min(result, Math.abs(pickSum - noPickSum));
            return;
        }

        for (int i = ind + 1; i < n; i++) {
            pick[count] = i;
            find(k, i, count + 1);
        }
    }
    
    static int calc(int[] pick) {
        int sum = 0;

        for (int i = 0; i < pick.length - 1; i++) {
            for (int j = i + 1; j < pick.length; j++) {
                sum += arr[pick[i]][pick[j]] + arr[pick[j]][pick[i]];
            }
        }

        return sum;
    }
}