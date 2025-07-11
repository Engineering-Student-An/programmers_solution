import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = h(k);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] h(long m) {

        if(m == 1) return arr;

        int[][] half = h(m / 2);

        if(m % 2 == 0) return mul(half, half);
        else return mul(mul(half, half), arr);
    }

    static int[][] mul(int[][] one, int[][] two) {

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (result[i][j] + (one[i][k] * two[k][j]) % 1000) % 1000;
                }
            }
        }

        return result;
    }
}