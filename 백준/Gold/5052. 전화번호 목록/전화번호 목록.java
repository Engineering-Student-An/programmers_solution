import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());

            String[] numbers = new String[n];
            Node root = new Node();
            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();

                Node now = root;
                for (int j = 0; j < numbers[i].length(); j++) {
                    int c = numbers[i].charAt(j) - '0';

                    if(now.next[c] == null) {
                        now.next[c] = new Node();
                    }

                    now = now.next[c];
                }
                now.num = i;
            }

            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                Node now = root;

                for (int j = 0; j < numbers[i].length(); j++) {
                    int c = numbers[i].charAt(j) - '0';

                    if(now.num != -1 && now.num != i) {
                        isPossible = false;
                        break;
                    }
                    now = now.next[c];
                }
                if(!isPossible) break;
            }

            sb.append((isPossible) ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }

    static class Node {
        Node[] next = new Node[10];
        int num = -1;
    }
}