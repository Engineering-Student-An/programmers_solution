import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node root = new Node();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            Node now = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if(now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new Node();
                }
                now = now.next[c - 'a'];
            }
            now.isFinal = true;
        }


        int result = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            Node now = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if(now.next[c- 'a'] == null) {
                    break;
                }
                now = now.next[c - 'a'];
                if(j == word.length() - 1 && now.isFinal) {
                    result ++;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isFinal;
    }
}