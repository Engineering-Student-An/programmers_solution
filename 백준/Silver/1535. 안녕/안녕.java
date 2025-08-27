import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] L = new int[n + 1];
        int[] J = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) L[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) J[i] = Integer.parseInt(st.nextToken());

        int[][] happiness = new int[n + 1][100];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 100; j++) {
                if(L[i] > j) happiness[i][j] = happiness[i-1][j];
                else happiness[i][j] = Math.max(happiness[i - 1][j], happiness[i - 1][j - L[i]] + J[i]);
            }
        }

        System.out.println(happiness[n][99]);
    }
}