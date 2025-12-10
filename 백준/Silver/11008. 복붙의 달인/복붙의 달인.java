import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String original = st.nextToken();
            String copy = st.nextToken();

            int index = 0;
            int count = 0;
            while (index < original.length()) {

                if(index > original.length() - copy.length()) {
                    index ++;
                    count ++;
                } else if (copy.equals(original.substring(index, index + copy.length()))) {
                    count ++;
                    index += copy.length();
                } else {
                    index ++;
                    count ++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}