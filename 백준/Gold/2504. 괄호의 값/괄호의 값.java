import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();

        long ans = 0;
        long mul = 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {

            char now = line.charAt(i);

            if(now == '(') {
                mul *= 2;
                stack.push('(');
            } else if(now == '[') {
                mul *= 3;
                stack.push('[');
            } else if(now == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    ans = 0;
                    break;
                }

                stack.pop();
                if(line.charAt(i - 1) == '(') {
                    ans += mul;
                }
                mul /= 2;
            } else if(now == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    ans = 0;
                    break;
                }

                stack.pop();
                if(line.charAt(i - 1) == '[') {
                    ans += mul;
                }
                mul /= 3;
            }
        }

        System.out.println(stack.isEmpty() ? ans : 0);
    }
}