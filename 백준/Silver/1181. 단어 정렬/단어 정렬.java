import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Set<String> set = new HashSet<>();

        Vector<String> vector = new Vector<>();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            set.add(s);
        }

        for (String s : set) {
            vector.add(s);
        }

        sort(vector);
        vector.sort((String a, String b) -> a.length() - b.length());

        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.elementAt(i));
        }
    }
}