import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] find = br.readLine().split("\\*");

        StringBuilder sb = new StringBuilder();
        int findLen = find[0].length() + find[1].length();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if(word.length() >= findLen && word.startsWith(find[0]) && word.endsWith(find[1])) {
                sb.append("DA").append("\n");
            } else sb.append("NE").append("\n");
        }

        System.out.print(sb);
    }
}