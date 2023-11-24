
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("0")) break;
            String pel = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                pel += str.charAt(i);
            }

            if (str.equals(pel)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}