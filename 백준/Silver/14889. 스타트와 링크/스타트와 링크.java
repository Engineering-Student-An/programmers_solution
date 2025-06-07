import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean isZero = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n/2; i++) {
            int[] list = new int[n/2];
            list[0] = i;
            team(i, 1, list);
            if(isZero) break;
        }

        System.out.println(min);
    }

    static void team(int index, int count, int[] list) {
        if(isZero) return;
        if(count == n/2) {

            int sum = checkSum(list);
            int[] remainList = new int[n/2];
            int ind = 0;
            for (int i = 1; i <= n; i++) {
                boolean chk = false;
                for (int j = 0; j < n/2; j++) {
                    if(list[j] == i) chk = true;
                }
                if(!chk) remainList[ind ++] = i;
            }
            int remainSum = checkSum(remainList);

            min = Math.min(min, Math.abs(sum - remainSum));
            if(min == 0) isZero = true;
            return;
        }

        for (int i = index + 1; i <= n - (n/2 - count) ; i++) {
            list[count] = i;
            team(i, count + 1, list);
        }
    }

    static int checkSum(int[] list) {
        int sum = 0;
        for (int i = 0; i < n/2; i++) {
            for (int j = i + 1; j < n/2; j++) {
                sum += arr[list[i]][list[j]] + arr[list[j]][list[i]];
            }
        }

        return sum;
    }
}