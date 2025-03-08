import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int index = 1;

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            while(arr[i] >= index) {
                stack.push(index ++);
                sb.append("+").append("\n");
            }

            if(!stack.isEmpty() && arr[i] == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
        }

        System.out.print(sb);
    }
}