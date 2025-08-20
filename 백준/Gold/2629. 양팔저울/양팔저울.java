import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static boolean[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        result = new boolean[n][total + 1];
        result[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            result[i][arr[i]] = true;
            for (int j = 1; j <= total; j++) {
                if(result[i-1][j]) {
                    result[i][j] = true;
                    result[i][j + arr[i]] = true;
                    if(Math.abs(j - arr[i]) >= 0) result[i][Math.abs(j - arr[i])] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int next = Integer.parseInt(st.nextToken());
            if(next > total) sb.append("N ");
            else sb.append(check(next) ? "Y " : "N ");
        }

        System.out.println(sb);
    }

    static boolean check(int next) {
        for (int i = 0; i < n; i++) {
            if(result[i][next]) return true;
        }

        return false;
    }
}