import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.next();
        String[] temp = line.split("-");

        int ans = 0;

        for (int i = 0; i < temp.length; i++) {
            String[] one = temp[i].split("\\+");

            int t = 0;
            for (String string : one) {
                t += Integer.parseInt(string);
            }

            if(i == 0) ans += t;
            else ans -= t;
        }

        System.out.println(ans);

    }
}