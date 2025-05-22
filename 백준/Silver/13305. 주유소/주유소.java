import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] cost = new long[n];
        long[] distance = new long[n-1];
        for (int i = 0; i < n-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        int now = 0;
        long sum = distance[0] * cost[0];

        for (int i = 1; i < n - 1; i++) {
            if(cost[now] > cost[i]) {
                now = i;
            }

            sum += cost[now] * distance[i];
        }

        System.out.println(sum);
    }
}