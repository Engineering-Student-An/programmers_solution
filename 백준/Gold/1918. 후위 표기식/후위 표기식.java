import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int n = line.length();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack();
        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);

            if(c >= 'A' && c <= 'Z') sb.append(c);
            else {
                if(c == '(') stack.push(c);
                else if(c == ')') {
                    while(!stack.isEmpty()) {
                        char sc = stack.pop();
                        if(sc == '(') break;
                        sb.append(sc);
                    }
                } else {
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static int priority(char c) {
        if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return 0;
    }
}