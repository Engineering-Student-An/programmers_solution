import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];

        fill(n, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j] ? "*" : " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void fill(int num, int r, int c) {
        if(num == 1) {
            arr[r][c] = true;
            return;
        }

        int div = num / 3;
        for (int i = 0; i < num; i+=div) {
            for (int j = 0; j < num; j+=div) {
                if(i == div && j == div) continue;

                fill(div, r + i, c + j);
            }
        }

    }
}