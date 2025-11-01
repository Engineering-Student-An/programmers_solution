import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = {"pi", "ka", "chu"};

        String line = br.readLine();
        int index = 0;

        boolean can = true;
        while (index < line.length()) {
            boolean isPossible = false;

            for (int i = 0; i < 3; i++) {
                if(line.length() - index < word[i].length()) continue;
                
                String sub = line.substring(index, index + word[i].length());

                if(sub.equals(word[i])) {
                    index += word[i].length();
                    isPossible = true;
                    break;
                }
            }

            if(!isPossible) {
                can = false;
                break;
            }
        }

        System.out.println(can ? "YES" : "NO");
    }
}