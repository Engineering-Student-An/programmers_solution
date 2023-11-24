import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        if(string.equals(" ")) {
            System.out.println(0);
        }else {
            int count = 1;
            for (int i = 1; i < string.length() - 1; i++) {

                if (string.charAt(i) == ' ') count++;
            }

            System.out.println(count);
        }
    }
}