import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();

        int n = original.length();
        int aCount = 0, bCount = 0;
        for (int i = 0; i < n; i++) {
            char c = original.charAt(i);
            if(c == 'a') aCount ++;
            else bCount ++;
        }

        int min = Integer.MAX_VALUE;
        String bs = "b".repeat(bCount);
        for (int k = 0; k <= aCount; k++) {
            String line = "a".repeat(k) + bs + "a".repeat(aCount - k);

            int count = 0;
            for (int i = 0; i < n; i++) {
                if(original.charAt(i) != line.charAt(i)) count ++;
            }

            min = Math.min(min, (count / 2));
        }

        String as = "a".repeat(aCount);
        for (int k = 1; k < bCount; k++) {
            String line = "b".repeat(k) + as + "b".repeat(bCount - k);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(original.charAt(i) != line.charAt(i)) count ++;
            }

            min = Math.min(min, (count / 2));
        }

        System.out.println(min);
    }
}