import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int index = -1;
        Set<String> set = new HashSet<>();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            if(arr[i].equals("?")) index = i;
            set.add(arr[i]);
        }

        char s = ' ', e = ' ';
        if(index > 0) {
            s = arr[index - 1].charAt(arr[index - 1].length() - 1);
        }
        if(index < n - 1) {
            e = arr[index + 1].charAt(0);
        }
        int m = Integer.parseInt(br.readLine());
        String ans = "";
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if ((s == ' ' || word.startsWith(s + "")) && (e == ' ' || word.endsWith(e + "")) && !set.contains(word)) {
                ans = word;
            }
        }

        System.out.println(ans);
    }
}