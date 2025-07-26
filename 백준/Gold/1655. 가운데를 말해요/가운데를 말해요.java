import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            left.add(num);
            if(!right.isEmpty() && left.peek() > right.peek()) {
                right.add(left.poll());
            }

            if(right.size() > left.size()) {
                while(left.size() - right.size() < 1) {
                    left.add(right.poll());
                }
            } else if(left.size() > right.size() + 1) {
                right.add(left.poll());
            }

            sb.append(left.peek()).append("\n");
        }

        System.out.print(sb);
    }
}