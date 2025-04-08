import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Deque<Character> left = new LinkedList<>();
        Deque<Character> right = new LinkedList<>();

        for (int i = 0; i < line.length(); i++) {
            left.addLast(line.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            char c = command.charAt(0);
            if(c == 'L') {
                if(!left.isEmpty()) {
                    right.addFirst(left.removeLast());
                }
            } else if(c == 'D') {
                if(!right.isEmpty()) {
                    left.addLast(right.removeFirst());
                }
            } else if(c == 'B') {
                if(!left.isEmpty()) {
                    left.removeLast();
                }
            } else {
                String word = st.nextToken();
                left.addLast(word.charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()) {
            sb.append(left.removeFirst());
        }
        while (!right.isEmpty()) {
            sb.append(right.removeFirst());
        }

        System.out.println(sb);
    }
}