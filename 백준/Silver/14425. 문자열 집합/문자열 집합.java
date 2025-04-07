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
            String s = br.readLine();
            Node now = root;
            for (int j = 0; j < s.length(); j++) {
                if(now.next[s.charAt(j) - 'a'] == null) {
                    now.next[s.charAt(j) - 'a'] = new Node();
                }

                now = now.next[s.charAt(j) - 'a'];
            }
            now.isEnd = true;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String line = br.readLine();

            Node now = root;
            for (int j = 0; j < line.length(); j++) {
                if(now.next[line.charAt(j) - 'a'] == null) break;

                now = now.next[line.charAt(j) - 'a'];
                if(j == line.length() - 1 && now.isEnd) count ++;
            }
        }

        System.out.println(count);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
}