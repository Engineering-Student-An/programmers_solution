import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] result = new long[2][46];
        result[0][0] = 1;
        result[1][1] = 1;
        for(int i = 2; i <= 45; i ++) {
            result[0][i] = result[0][i - 1] + result[0][i - 2];
            result[1][i] = result[1][i - 1] + result[1][i - 2];
        }

        System.out.println(result[0][n] + " " + result[1][n]);
    }
}