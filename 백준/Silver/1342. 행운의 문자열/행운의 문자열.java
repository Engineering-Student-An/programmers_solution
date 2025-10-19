import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, result = 0;
    static String line;
    static int[] count = new int[26];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        n = line.length();
        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);
            count[c - 'a'] ++;
        }

        for (int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                char c = (char) ('a' + i);
                count[i] --;
                find(1, String.valueOf(c));
                count[i] ++;
            }
        }

        System.out.println(result);
    }

    static void find(int len, String word) {
        if(len == n) {
            result ++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            char before = word.charAt(len - 1);
            char c = (char) ('a' + i);

            if(before == c) continue;

            if(count[i] > 0) {
                count[i] --;
                find(len + 1, word + c);
                count[i] ++;
            }
        }
    }
}