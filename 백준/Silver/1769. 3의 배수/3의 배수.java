import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();

        int count = 0;
        while(num.length()>1){
            count ++;
            Integer sum = 0;

            for (int i = 0; i < num.length(); i++) {
                sum += (int) (num.charAt(i)-'0');
            }
            num = sum.toString();
        }
        System.out.println(count);
        System.out.println( ((num.charAt(0)-'0') % 3) == 0 ? "YES" : "NO");
    }
}