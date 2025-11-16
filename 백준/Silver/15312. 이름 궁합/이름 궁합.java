import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        int[][] result = new int[2 * n + 1][2 * n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            result[2 * n][2 * i] = count[a.charAt(i) - 'A'];
            result[2 * n][2 * i + 1] = count[b.charAt(i) - 'A'];
        }

        for (int i = 2 * n - 1; i >= 2; i--) {
            for (int j = 0; j < i; j++) {
                result[i][j] = (result[i + 1][j] + result[i + 1][j + 1]) % 10;
            }
        }

        System.out.println(result[2][0] + "" + result[2][1]);
    }
}