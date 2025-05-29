import org.w3c.dom.Node;

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
            String line = br.readLine();

            Node now = root;
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if(now.next[c - 'a'] == null) now.next[c - 'a'] = new Node();
                now = now.next[c - 'a'];
            }
            now.isEnd = true;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String line = br.readLine();

            boolean isExist = false;
            Node now = root;
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if(now.next[c-'a'] == null) break;

                now = now.next[c - 'a'];

                if(j == line.length() - 1 && now.isEnd) isExist = true;
            }

            if(isExist) count ++;
        }

        System.out.println(count);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
}