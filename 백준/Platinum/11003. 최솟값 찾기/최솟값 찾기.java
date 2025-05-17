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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Info> deque = new LinkedList<>();
        deque.add(new Info(arr[0], 0));

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");
        for (int i = 1; i < n; i++) {

            // l 넘은 수는 제거
            if(i - deque.getFirst().index >= l) deque.removeFirst();

            // 지금 수 보다 큰 수는 제거
            while(!deque.isEmpty()) {
                if(deque.getLast().value > arr[i]) {
                    deque.removeLast();
                } else break;
            }
            deque.addLast(new Info(arr[i], i));

            sb.append(deque.getFirst().value).append(" ");
        }

        System.out.println(sb);
    }

    static class Info {
        int value;
        int index;

        public Info(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}