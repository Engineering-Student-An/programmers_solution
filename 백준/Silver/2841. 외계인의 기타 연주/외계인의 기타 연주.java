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
        int p = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] queue = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) {
            queue[i] = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int count = 0;
            while(!queue[i].isEmpty() && queue[i].peek() > k){
                count ++;
                queue[i].poll();
            }

            if(queue[i].isEmpty() || queue[i].peek() != k) {
                count ++;
                queue[i].add(k);
            }

            ans += count;
        }

        System.out.println(ans);
    }
}