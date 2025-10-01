import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < m; j++) {
                if(line.charAt(j) == 'c') stack.push(j);
            }

            for (int j = m - 1; j >= 0; j--) {
                if (stack.isEmpty()) result[i][j] = -1;
                else {
                    if(stack.peek() == j) {
                        result[i][j] = 0;
                        stack.pop();
                    } else if(stack.peek() < j) {
                        result[i][j] = j - (stack.peek());
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}