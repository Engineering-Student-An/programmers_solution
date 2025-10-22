
/*
    0    1   2   3   4   5   6   7   8   9
1   1    1
2   1    2   0
3   1    3   0   0
4   1    4   2   0
5   1    5   5   0
6   1    6   9   2   0
7   1    7   14  7   0
8   1    8   20  16  2
9   1    9   27  30  9

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());


        if(k > n/2) System.out.println(0);
        else {
            long[][] arr = new long[n + 1][n / 2 + 2];
            for (int i = 0; i <= n; i++) {
                arr[i][0] = 1;
                arr[i][1] = i;
            }

            long mod = 1000000003;
            for (int i = 4; i <= n; i++) {
                for (int j = 2; j <= i / 2; j++) {
                    arr[i][j] = (arr[i-2][j-1] + arr[i-1][j]) % mod;
                }
            }

            System.out.println(arr[n][k]);
        }
    }
}