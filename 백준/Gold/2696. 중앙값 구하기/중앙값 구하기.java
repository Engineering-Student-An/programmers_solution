import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            int n = Integer.parseInt(br.readLine());

            Queue<Long> answer = new LinkedList<>();
            PriorityQueue<Long> left = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
            PriorityQueue<Long> right = new PriorityQueue<>();


            int repeat = (n % 10 == 0) ? n / 10 : n / 10 + 1;
            for (int k = 0; k < repeat; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int m = (n >= 10) ? 10 : n % 10;
                for (int i = 1; i <= m; i++) {
                    Long num = Long.parseLong(st.nextToken());

                    // 홀수 번째 (짝수개 = 짝수개)
                    if(i % 2 == 1) {
                        left.add(num);
                        right.add(left.poll());
                        // 중앙값 추출
                        answer.add(right.peek());
                    }
                    // 짝수 번째 (홀수개 < 짝수개)
                    else {
                        right.add(num);
                        left.add(right.poll());
                    }
                }
                n -= 10;
            }


            sb.append(answer.size()).append("\n");
            int count = 0;
            while (!answer.isEmpty()) {
                if(count > 0 && count % 10 == 0) sb.append("\n");
                sb.append(answer.poll()).append(" ");
                count ++;
            }
            sb.append("\n");

        }

        System.out.print(sb);
    }
}