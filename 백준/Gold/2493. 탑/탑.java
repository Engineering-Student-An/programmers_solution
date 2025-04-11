import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n+1];
        int index = 1;

        Stack<Info> stack = new Stack<>();
        stack.add(new Info(Integer.MAX_VALUE, 0));

        while(index <= n && !stack.isEmpty()) {

            Info now = stack.peek();
            if(now.h > arr[index]) {
                result[index] = now.index;
                stack.add(new Info(arr[index], index++));
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    static class Info {
        int h;
        int index;

        public Info(int h, int index) {
            this.h = h;
            this.index = index;
        }
    }
}