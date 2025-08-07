import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isTag = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if(!isTag && c != '<' && c != ' ') {
                stack.push(c);
            } else if(!isTag && c == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            } else {
                if(c == '<') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    isTag = true;
                }
                else if(c == '>') isTag = false;

                sb.append(c);
            }

        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}