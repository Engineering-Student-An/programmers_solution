import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static long n, p, q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);
        System.out.println(seq(n));
    }

    static Long seq(long num) {
        if(num == 0) return 1L;

        Long first, second;
        if(map.get(num / p) == null) {
            first = seq(num / p);
            map.put(num / p, first);
        } else {
            first = map.get(num / p);
        }

        if (map.get(num / q) == null) {
            second = seq(num / q);
            map.put(num / q, second);
        } else {
            second = map.get(num / q);
        }

        Long result = first + second;
        if(map.get(num) == null) map.put(num, result);

        return result;
    }
}