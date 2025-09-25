import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] fibo = new int[46];
        fibo[1] = 1;
        for (int i = 2; i < 46; i++) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j = 45; j >= 0; j--) {
                if(num >= fibo[j]) {
                    num -= fibo[j];
                    queue.add(fibo[j]);
                }

                if(num == 0) break;
            }

            while (!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}