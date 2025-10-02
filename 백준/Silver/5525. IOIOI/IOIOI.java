import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String nn = "I";
        nn = nn + "OI".repeat(n);

        int l = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int count = 0;
        for (int i = 0; i <= l - nn.length(); i++) {

            boolean isPossible = true;
            for (int j = 0; j < nn.length(); j++) {
                if(nn.charAt(j) != line.charAt(i + j)) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) count ++;
        }

        System.out.println(count);
    }
}