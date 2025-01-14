import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int c;
    static char[] arr;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        c = scanner.nextInt();

         arr = new char[c];

        for (int i = 0; i < c; i++) {
            String ch = scanner.next();
            arr[i] = ch.charAt(0);
        }

        Arrays.sort(arr);

        for (int i = 0; i <= c-n; i++) {

            String word = String.valueOf(arr[i]);
            find(word, i);
        }

        System.out.print(sb);
    }

    static void find(String word, int index) {

        if(word.length() == n && checkPossibility(word)) {
            sb.append(word).append("\n");
            return;
        }

        for (int i = index + 1; i < c; i++) {
            String nextWord = word + arr[i];
            find(nextWord, i);
        }
    }

    static boolean checkPossibility(String word) {
        int mo = 0;
        int ja = 0;

        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
                mo ++;
            } else {
                ja ++;
            }
        }

        return mo >= 1 && ja >= 2;
    }
}