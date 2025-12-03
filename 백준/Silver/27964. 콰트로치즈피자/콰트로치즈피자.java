import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Cheese
        char[] ch = {'C', 'h', 'e', 'e', 's', 'e'};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String word = st.nextToken();

            int len = word.length();
            if(!set.contains(word) && len >= 6) {
                boolean chk = true;
                for (int j = 0; j < 6; j++) {
                    if(ch[j] != word.charAt(len - (6 - j))) {
                        chk = false;
                        break;
                    }
                }
                if(chk) set.add(word);
            }

            if(set.size() >= 4) break;
        }

        System.out.println((set.size() >= 4) ? "yummy" : "sad");
    }
}