import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Data> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            while(!stack.isEmpty() && stack.peek().value < arr[i]) {
                Data pop = stack.pop();
                result[pop.index] = arr[i];
            }
            stack.push(new Data(arr[i], i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((result[i] == 0 ? -1 : result[i])).append(" ");
        }
        System.out.print(sb);
    }

    static class Data {
        int value;
        int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}