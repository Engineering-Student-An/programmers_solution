import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        // 알파벳 별 누적합
        int[][] sum = new int[26][word.length()];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            sum[index][i] ++;

            if(i > 0) {
                for (int j = 0; j < 26; j++) {
                    sum[j][i] += sum[j][i - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(l == 0) sb.append(sum[c-'a'][r]).append("\n");
            else sb.append(sum[c - 'a'][r] - sum[c - 'a'][l - 1]).append("\n");
        }

        System.out.print(sb);
    }
}