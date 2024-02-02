import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        boolean isFinish = false;
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()) {
                stack.push(cnt++);
                sb.append("+" + "\n");
            }
            while(stack.peek()!=arr[i]){
                stack.push(cnt++);
                sb.append("+" + "\n");
                if(cnt > n+1) {
                    isFinish = true;
                    break;
                }
            }
            if(isFinish){
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
            stack.pop();
            sb.append("-" + "\n");
        }
        System.out.print(sb);
    }
}