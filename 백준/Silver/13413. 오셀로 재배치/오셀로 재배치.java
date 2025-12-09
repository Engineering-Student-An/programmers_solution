import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String s2 = br.readLine();

            int w = 0, b = 0;
            for (int i = 0; i < n; i++) {
                char c = s2.charAt(i);
                if(c != s1.charAt(i)) {
                    if(c == 'W') w ++;
                    else b ++;
                }
            }

            int result = Math.min(w, b);
            
            result += Math.abs(w - b);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}