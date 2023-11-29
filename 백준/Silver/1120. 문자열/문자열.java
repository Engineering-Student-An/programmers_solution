import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        int min = 100;
        int count = 0;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            String subB = b.substring(i, i + a.length());
            count = 0;
            for (int j = 0; j < subB.length(); j++) {
                if(subB.charAt(j) != a.charAt(j)) count++;
            }
            if(count < min) min = count;
        }

        System.out.println(min);
    }
}