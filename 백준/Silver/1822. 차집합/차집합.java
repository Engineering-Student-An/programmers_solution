import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer num : aSet) {
            if(!bSet.contains(num)) queue.add(num);
        }

        System.out.println(queue.size());

        if(!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }

            System.out.print(sb);
        }
    }
}