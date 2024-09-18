import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] tmp = new int[3];
        int[][] max = new int[n+1][3];
        int[][] min = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + tmp[0];
            min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + tmp[1];
            min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + tmp[2];

            max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + tmp[0];
            max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + tmp[1];
            max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + tmp[2];
        }

        System.out.print(Math.max(Math.max(max[n][0], max[n][1]), max[n][2]) + " ");
        System.out.print(Math.min(Math.min(min[n][0], min[n][1]), min[n][2]));
    }
}