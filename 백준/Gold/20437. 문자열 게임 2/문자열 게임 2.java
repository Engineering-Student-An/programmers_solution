import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tt = 0; tt < t; tt++) {
            String line = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if(k == 1) {
                sb.append("1 1\n");
                continue;
            }

            int n = line.length();
            int[] alphabet = new int[26];
            for (int i = 0; i < n; i++) {
                alphabet[line.charAt(i) - 'a'] ++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int i = 0; i < n; i++) {
                if(alphabet[line.charAt(i) - 'a'] < k) continue;
                int count = 1;
                for (int j = i+1; j < n; j++) {
                    if(line.charAt(j) == line.charAt(i)) count ++;

                    if(count == k) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }


            }
            if(min != Integer.MAX_VALUE && max != -1) sb.append(min).append(" ").append(max).append("\n");
            else sb.append("-1\n");
        }
        System.out.print(sb);
    }
}