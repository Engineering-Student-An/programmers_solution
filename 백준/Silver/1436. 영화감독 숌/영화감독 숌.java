import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int count = 0;

        long num = 666;
        while(true) {

            String string = String.valueOf(num);
            if(string.contains("666")) count ++;

            if(count == n) break;

            num ++;
        }

        System.out.println(num);
    }
}