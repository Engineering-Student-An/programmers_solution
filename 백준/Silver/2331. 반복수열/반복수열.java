import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int p;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(a, count++);
        int before = a;

        while(true) {
            int next = calc(before);

            if(map.containsKey(next)) {
                System.out.println(map.get(next));
                break;
            }

            map.put(next, count++);
            before = next;
        }
    }

    static int calc(int n) {
        int result = 0;
        while(n > 0) {
            result += (int) Math.pow(n % 10, p);
            n /= 10;
        }

        return result;
    }
}
