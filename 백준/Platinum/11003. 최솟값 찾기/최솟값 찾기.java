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
        int l = Integer.parseInt(st.nextToken());

        Deque<Info> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        deque.add(new Info(0, arr[0]));
        sb.append(deque.getFirst().value).append(" ");

        for (int i = 1; i < n; i++) {

            while(!deque.isEmpty() && deque.getLast().value > arr[i]) {
                deque.removeLast();
            }
            deque.addLast(new Info(i, arr[i]));

            if(i - deque.getFirst().index >= l) {
                deque.removeFirst();
            }

            sb.append(deque.getFirst().value).append(" ");
        }

        System.out.print(sb);
    }

    static class Info {
        int index;
        int value;

        public Info(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}