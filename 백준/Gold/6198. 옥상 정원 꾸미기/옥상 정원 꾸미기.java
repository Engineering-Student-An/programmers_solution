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

        Stack<Integer> stack = new Stack<>();
        long count = 0;
        stack.push(arr[0]);

        for (int i = 1; i < n; i++) {
            int now = arr[i];

            while(!stack.isEmpty() && stack.peek() <= now) {
                stack.pop();
            }

            count += (stack.size());
            stack.push(now);
        }

        System.out.println(count);
    }
}
