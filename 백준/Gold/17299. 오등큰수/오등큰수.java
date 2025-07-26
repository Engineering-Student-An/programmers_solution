import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]] ++;
        }

        int[] result = new int[n];
        int index = n-1;
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            if(stack.isEmpty()) {
                result[index --] = -1;
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && count[stack.peek()] <= count[arr[i]]) {
                    stack.pop();
                }
                result[index --] = (stack.isEmpty()) ? -1 : stack.peek();
                stack.push(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}