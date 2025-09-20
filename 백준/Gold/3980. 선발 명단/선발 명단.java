import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n = 11;
    static int[][] arr = new int[n][n];
    static int result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = Integer.MIN_VALUE;
            visit = new boolean[n];
            find(0, 0);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static void find(int index, int sum) {

        if(index == n) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i] && arr[index][i] > 0) {
                visit[i] = true;
                find(index + 1, sum + arr[index][i]);
                visit[i] = false;
            }
        }
    }
}