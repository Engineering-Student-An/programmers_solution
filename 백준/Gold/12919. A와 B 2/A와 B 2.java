import java.util.Scanner;

public class Main {

    static boolean isFound = false;
    static String original;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        original = scanner.next();
        String find = scanner.next();

        game(find);

        System.out.println(isFound ? 1 : 0);
    }

    static void game(String find) {
        if(find.equals(original) || isFound) {
            isFound = true;
            return;
        }

        if(find.charAt(0) == 'B') {
            String temp = "";
            for (int i = find.length() - 1; i > 0; i--) {
                temp += find.charAt(i);
            }
            if(temp.length() > 0) game(temp);
        }
        if(find.equals(original) || isFound) {
            isFound = true;
            return;
        }

        if(find.charAt(find.length() - 1) == 'A') {
            String temp = find.substring(0, find.length() - 1);
            if(temp.length() > 0) game(temp);
        }
    }
}