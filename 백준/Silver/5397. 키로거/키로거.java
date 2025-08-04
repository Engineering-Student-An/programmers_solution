import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            String line = br.readLine();

            Deque<Character> left = new LinkedList<>();
            Deque<Character> right = new LinkedList<>();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if(c == '<') {
                    if(!left.isEmpty()) right.addFirst(left.removeLast());
                } else if(c == '>') {
                    if(!right.isEmpty()) left.addLast(right.removeFirst());
                } else if(c == '-') {
                    if(!left.isEmpty()) left.removeLast();
                } else {
                    left.addLast(c);
                }
            }

            while(!left.isEmpty()) {
                sb.append(left.removeFirst());
            }
            while (!right.isEmpty()) {
                sb.append(right.removeFirst());
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}