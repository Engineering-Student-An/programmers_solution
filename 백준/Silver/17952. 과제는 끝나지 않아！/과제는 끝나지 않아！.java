import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        Info now = null;
        Stack<Info> stack = new Stack<>();
        while(n -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type == 1) {
                int score = Integer.parseInt(st.nextToken());
                int remain = Integer.parseInt(st.nextToken());

                if(now != null) stack.push(now);
                now = new Info(score, remain);
            }

            if(now == null) continue;

            now.remain --;
            if(now.remain == 0) {
                sum += now.score;
                now = (stack.isEmpty()) ? null : stack.pop();
            }

        }

        System.out.println(sum);
    }

    static class Info {
        int score, remain;

        public Info(int score, int remain) {
            this.score = score;
            this.remain = remain;
        }
    }
}