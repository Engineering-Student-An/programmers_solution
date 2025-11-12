import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Double> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            double now = Double.parseDouble(br.readLine());
            if (queue.size() < 7) {
                queue.add(now);
            } else if(queue.peek() > now) {
                queue.poll();
                queue.add(now);
            }
        }

        double[] arr = new double[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = queue.poll();
        }

        for (int i = 6; i >= 0; i--) {
            System.out.printf("%.3f\n", arr[i]);
        }
    }
}