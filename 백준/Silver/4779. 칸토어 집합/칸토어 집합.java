import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] result = new String[13];
        result[0] = "-";
        for (int i = 1; i < 13; i++) {
            result[i] = result[i-1] + " ".repeat(result[i-1].length()) + result[i-1];
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line == null || line.isEmpty()) break;
            int n = Integer.parseInt(line);

            sb.append(result[n]).append("\n");
        }

        System.out.print(sb);
    }
}