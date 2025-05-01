import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];
        for(int i = 1; i <= n; i ++) {
            String line = br.readLine();
            for(int j = 1; j <= m; j ++) {
                arr[i][j] = (int) line.charAt(j-1) - '0';
            }
        }

        int[][] result = new int[n+1][m+1];
        int max = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] = Math.min(Math.min(arr[i-1][j], arr[i][j-1]), arr[i-1][j-1]) + 1;
                }

                max = Math.max(arr[i][j], max);
            }
        }

        System.out.println(max * max);
    }
}