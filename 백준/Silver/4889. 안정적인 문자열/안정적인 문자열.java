import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int testCase = 1;
        while(true) {
            String line = br.readLine();
            if(line.charAt(0) == '-') break;

            int count = 0;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(c == '{') stack.push(1);
                else {
                    if(stack.isEmpty()) {
                        count ++;
                        stack.push(1);
                    } else {
                        stack.pop();
                    }
                }
            }

            count += (stack.size() / 2);

            sb.append(testCase ++).append(". ").append(count).append("\n");
        }

        System.out.print(sb);
    }
}