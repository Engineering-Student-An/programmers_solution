import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < n; i++) {
            int sum = i;

            int j = i;
            while(j > 0) {
                sum += (j % 10);
                j /= 10;
            }

            if(sum == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}