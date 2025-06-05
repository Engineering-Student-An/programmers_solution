import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            String line = br.readLine();
            if(line.equals(".")) break;

            boolean ans = true;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(c == '(') stack.push(1);
                else if(c == '[') stack.push(2);
                else if(c == ']') {
                    if(stack.isEmpty() || stack.peek() != 2) {
                        ans = false;
                        break;
                    }
                    stack.pop();
                }
                else if(c == ')') {
                    if(stack.isEmpty() || stack.peek() != 1) {
                        ans = false;
                        break;
                    }
                    stack.pop();
                }
            }

            sb.append((!ans || !stack.isEmpty()) ? "no" : "yes").append("\n");
        }
        System.out.print(sb);
    }
}