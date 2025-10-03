import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            if(map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.replace(num, map.get(num) + 1);
            }
        }

        int max = -1;
        long result = 0;
        for(Long num : map.keySet()) {

            if(max == map.get(num)) {
                if(result > num) result = num;
            } else if(max < map.get(num)) {
                max = map.get(num);
                result = num;
            }


        }

        System.out.println(result);
    }
}