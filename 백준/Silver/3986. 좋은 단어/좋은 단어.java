import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < line.length(); j++) {
                char now = line.charAt(j);

                if (stack.isEmpty()) {
                    stack.push(now);
                } else {
                    if(now == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(now);
                    }
                }
            }

            if(stack.isEmpty()) result ++;
        }
        System.out.println(result);
    }
}