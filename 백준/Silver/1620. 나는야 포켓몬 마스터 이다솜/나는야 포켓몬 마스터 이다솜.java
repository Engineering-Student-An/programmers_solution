import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> name = new HashMap<>();
        Map<String, String> num = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            name.put(String.valueOf(i), line);
            num.put(line, String.valueOf(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            if(name.get(line) == null) {
                sb.append(num.get(line)).append("\n");
            } else sb.append(name.get(line)).append("\n");
        }

        System.out.print(sb);
    }
}