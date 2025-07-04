import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String word = scanner.next();

        Set<String> set = new HashSet<>();

        for (int len = 0; len < word.length(); len++) {
            for (int i = 0; i < word.length() - len; i++) {
                String w = word.substring(i, i + len + 1);
                set.add(w);
            }
        }

        System.out.println(set.size());
    }
}