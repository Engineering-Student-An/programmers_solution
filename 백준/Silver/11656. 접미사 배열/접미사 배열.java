import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        String[] arr = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            String w = word.substring(i, word.length());
            arr[i] = w;
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}