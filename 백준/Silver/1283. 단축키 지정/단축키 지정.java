import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] alpha = new int[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();

            int index = -1;

            String upper = line.toUpperCase();
            String[] split = upper.split(" ");
            for (int j = 0; j < split.length; j++) {
                if(alpha[split[j].charAt(0) - 'A'] == 0) {
                    alpha[split[j].charAt(0) - 'A'] = i;
                    index = j;
                    break;
                }
            }
            if(index != -1) {
                int indCheck = 0;
                for (int j = 0; j < index; j++) {
                    indCheck += split[j].length();
                }
                index = (index > 0) ? indCheck + index : indCheck;
            } else {
                for (int j = 0; j < line.length(); j++) {
                    if(upper.charAt(j) != ' ' && alpha[upper.charAt(j) - 'A'] == 0) {
                        alpha[upper.charAt(j) - 'A'] = i;
                        index = j;
                        break;
                    }
                }
            }

            for (int j = 0; j < line.length(); j++) {
                if(j == index) {
                    sb.append("[").append(line.charAt(j)).append("]");
                } else {
                    sb.append(line.charAt(j));
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}