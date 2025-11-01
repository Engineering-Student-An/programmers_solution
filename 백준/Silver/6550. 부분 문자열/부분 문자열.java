import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String line = br.readLine();
            if(line == null || line.isEmpty()) break;

            String[] split = line.split(" ");
            String find = split[0];
            line = split[1];

            int index = 0;
            boolean isPossible = false;
            for (int i = 0; i < line.length(); i++) {
                char c = find.charAt(index);

                if(c == line.charAt(i)) {
                    index ++;
                }

                if(index == find.length()) {
                    isPossible = true;
                    break;
                }
            }

            if(isPossible) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }

        System.out.print(sb);
    }
}