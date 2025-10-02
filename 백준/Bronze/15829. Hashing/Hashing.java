import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        String line = br.readLine();

        long result = 0;
        for (int i = 0; i < l; i++) {
            long c = (line.charAt(i) - 'a') + 1;

            for (int j = 0; j < i; j++) {
                c = (c * 31) % 1234567891;
            }

            result = (result + c) % 1234567891;
        }

        System.out.println(result);
    }
}
