import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();

        while (t.length() > s.length()) {
            if(t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length() - 1);
            } else {
                t = t.substring(0, t.length() - 1);
                String temp = "";
                for (int i = t.length() - 1; i >= 0; i--) {
                    temp += t.charAt(i);
                }
                t = temp;
            }
        }

        System.out.println((s.equals(t)) ? 1 : 0);
    }
}