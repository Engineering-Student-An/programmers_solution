import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String command = scanner.next();
            if(command.equals("push")) {
                int num = scanner.nextInt();
                stack.push(num);
            } else if(command.equals("pop")) {
                sb.append(!stack.isEmpty() ? stack.pop() : "-1").append("\n");
            } else if(command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if(command.equals("empty")) {
                sb.append(stack.isEmpty() ? "1" : "0").append("\n");
            } else if(command.equals("top")) {
                sb.append(!stack.isEmpty() ? stack.peek() : "-1").append("\n");
            }
        }

        System.out.print(sb);
    }
}