import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            Stack<Integer> stack = new Stack<>();
            boolean isFinish = false;
            for (int j = 0; j < line.length(); j++) {
                if(line.charAt(j) == '(') {
                    stack.push(1);
                } else {
                    if(stack.isEmpty()) {
                        isFinish = true;
                        sb.append("NO").append("\n");
                        break;
                    }
                    stack.pop();
                }
            }

            if(!isFinish) {
                sb.append( (stack.isEmpty()) ? "YES" : "NO").append("\n");
            }

        }

        System.out.print(sb);
    }
}