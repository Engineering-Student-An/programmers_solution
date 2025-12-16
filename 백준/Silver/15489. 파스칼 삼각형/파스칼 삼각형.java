import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        long[][] arr = new long[31][31];
        for (int i = 0; i < 31; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < 31; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        long sum = 0;
        int ind = 0;
        for (int i = r - 1; i < r + w - 1; i++) {
            for (int j = c - 1; j < c + ind; j++) {
                sum += arr[i][j];
            }
            ind ++;
        }

        System.out.println(sum);
    }
}