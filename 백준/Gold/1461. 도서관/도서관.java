import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plus = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        int absMax = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(Math.abs(num) > Math.abs(absMax)) absMax = num;

            if(num < 0) minus.add(num);
            else plus.add(num);
        }

        int sum = 0;
        while (!plus.isEmpty()) {
            Integer now = plus.poll();
            for (int i = 0; i < k - 1; i++) if(!plus.isEmpty()) plus.poll();

            sum += (now == absMax) ? now : now * 2;
        }

        while (!minus.isEmpty()) {
            Integer now = minus.poll();
            for (int i = 0; i < k - 1; i++) if(!minus.isEmpty()) minus.poll();

            sum += (now == absMax) ? Math.abs(now) : Math.abs(now) * 2;
        }

        System.out.println(sum);
    }
}