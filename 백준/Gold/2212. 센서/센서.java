import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < n - 1; i++) {
            queue.add(arr[i + 1] - arr[i]);
        }

        while(!queue.isEmpty() && k > 1) {
            queue.poll();
            k --;
        }

        long sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }

        System.out.println(sum);
    }
}