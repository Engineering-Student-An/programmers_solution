import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            deque.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            Integer now = deque.removeFirst();
            sb.append(now).append(" ");

            if(deque.isEmpty()) break;

            int move = arr[now];
            if(move < 0) {
                move = (-1 * move) % deque.size();
                for (int i = 0; i < move; i++) {
                    deque.addFirst(deque.removeLast());
                }
            } else {
                move = (move - 1) % deque.size();
                for (int i = 0; i < move; i++) {
                    deque.addLast(deque.removeFirst());
                }
            }
        }

        System.out.println(sb);
    }
}