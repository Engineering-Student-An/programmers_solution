import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(n == 1) System.out.println(0);
        else {

            int[] result = new int[n];
            result[0] = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while (!queue.isEmpty()) {
                Integer now = queue.poll();
                for (int i = 1; i <= arr[now]; i++) {
                    int next = now + i;
                    if (next < n && result[next] == 0) {
                        result[next] = result[now] + 1;
                        queue.add(next);
                    }
                }
            }
            System.out.println(result[n - 1] == 0 ? -1 : result[n - 1]);
        }
    }
}