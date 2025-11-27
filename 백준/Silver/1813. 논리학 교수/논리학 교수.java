import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(!map.containsKey(num)) map.put(num, 1);
            else map.replace(num, map.get(num) + 1);
        }

        int result = -1;
        for (Integer k : map.keySet()) {
            if(k.equals(map.get(k))) {
                result = Math.max(result, k);
            }
        }

        if(result == -1 && map.get(0) == null) System.out.println(0);
        else System.out.println(result);
    }
}