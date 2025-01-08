import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            if(line.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if(line.equals("pop")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.removeFirst()).append("\n");
                }
            } else if(line.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if(line.equals("empty")) {
                sb.append((deque.isEmpty()) ? 1 : 0).append("\n");
            } else if(line.equals("front")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getFirst()).append("\n");
                }
            } else if(line.equals("back")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getLast()).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}