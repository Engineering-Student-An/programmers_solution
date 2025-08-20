import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> in = new HashMap<>();
        String[] out = new String[n];
        for (int i = 0; i < n; i++) in.put(br.readLine(), i);
        for (int i = 0; i < n; i++) out[i] = br.readLine();

        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            int now = in.get(out[i]);
            for (int j = i + 1; j < n; j++) {
                if(in.get(out[j]) < now) {
                    result ++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}