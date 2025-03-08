import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Stack<Info> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            int now = arr[i];

            while(!stack.isEmpty() && stack.peek().value < now) {
                Info info = stack.pop();
                result[info.index] = now;
            }

            stack.push(new Info(i, now));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((result[i] == 0) ? -1 : result[i]).append(" ");
        }

        System.out.println(sb);
    }

    static class Info {
        int index;
        int value;

        public Info(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}