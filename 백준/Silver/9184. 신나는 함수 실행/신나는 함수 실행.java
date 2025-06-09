import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][][] arr = new long[21][21][21];
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                arr[0][i][j] = 1;
            }
        }
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                arr[i][0][j] = 1;
            }
        }
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                arr[i][j][0] = 1;
            }
        }

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                for (int k = 1; k <= 20; k++) {
                    if(i < j && j < k) arr[i][j][k] = arr[i][j][k-1] + arr[i][j-1][k-1] - arr[i][j-1][k];
                    else arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
                }
            }
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;

            if(a <= 0 || b <= 0 || c <= 0) sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(1).append("\n");
            else if(a > 20 || b > 20 || c > 20) sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(arr[20][20][20]).append("\n");
            else sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(arr[a][b][c]).append("\n");
        }

        System.out.print(sb);

    }
}