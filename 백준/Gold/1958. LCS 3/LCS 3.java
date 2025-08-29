import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] string = new String[3];
        for (int i = 0; i < 3; i++) {
            string[i] = br.readLine();
        }

        int n = string[0].length();
        int m = string[1].length();
        int p = string[2].length();
        int[][][] lcs = new int[n+1][m+1][p+1];

        for (int i = 1; i <= n; i++) {
            char one = string[0].charAt(i-1);
            for (int j = 1; j <= m; j++) {
                char two = string[1].charAt(j-1);
                for (int k = 1; k <= p; k++) {
                    char three = string[2].charAt(k-1);

                    if(one == two && two == three) lcs[i][j][k] = lcs[i-1][j-1][k-1] + 1;
                    else lcs[i][j][k] = Math.max(lcs[i - 1][j][k], Math.max(lcs[i][j - 1][k], lcs[i][j][k - 1]));
                }
            }
        }

        System.out.println(lcs[n][m][p]);
    }
}