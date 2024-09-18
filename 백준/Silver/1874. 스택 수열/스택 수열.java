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

        int next = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int plus = 0;
        int minus = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+").append("\n");
            plus ++;

            while (!stack.isEmpty() && next < n) {
                if(arr[next] == stack.peek()) {
                    minus++;
                    sb.append("-").append("\n");
                    stack.pop();
                    next++;
                } else {
                    break;
                }
            }
        }

        System.out.print((plus == minus) ? sb : "NO");
    }
}