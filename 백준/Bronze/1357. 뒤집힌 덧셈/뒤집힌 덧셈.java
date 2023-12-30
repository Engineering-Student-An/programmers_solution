import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String x = scanner.next();
        String y = scanner.next();

        int rev_x = Integer.parseInt(rev(x));
        int rev_y = Integer.parseInt(rev(y));


        System.out.println(Integer.parseInt(rev(Integer.toString(rev_x + rev_y))));


    }
    public static String rev(String x){
        String rev_x="";
        for(int i=x.length()-1;i>=0;i--){
            rev_x += x.charAt(i);
        }
        return rev_x;
    }
}