import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if(map.containsKey(name)) map.replace(name, map.get(name) + 1);
            else map.put(name, 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String name = br.readLine();
            map.replace(name, map.get(name) - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String name : map.keySet()) {
            if(map.get(name) > 0) {
                sb.append(name);
                break;
            }
        }

        System.out.print(sb);
    }
}