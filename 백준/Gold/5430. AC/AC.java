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

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String func = st.nextToken();

            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            String array = st.nextToken();

            array = array.substring(1, array.length() - 1);
            String[] split = array.split(",");

            Deque<Integer> deque = new LinkedList<>();
            for (String string : split) {
                if(!string.isEmpty()) {
                    deque.addLast(Integer.parseInt(string));
                }
            }

            boolean isReversed = false;
            boolean isPossible = true;
            for (int j = 0; j < func.length(); j++) {
                if(func.charAt(j) == 'R') {
                    isReversed = !isReversed;
                } else {
                    if(deque.isEmpty()) {
                        isPossible = false;
                        break;
                    }

                    if(isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if(isPossible) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (isReversed) {
                        sb.append(deque.getLast());
                        deque.removeLast();
                    } else {
                        sb.append(deque.getFirst());
                        deque.removeFirst();
                    }

                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            } else {
                sb.append("error").append("\n");
            }
        }

        System.out.print(sb);
    }
}