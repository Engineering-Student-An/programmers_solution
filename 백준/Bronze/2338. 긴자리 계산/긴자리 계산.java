import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException{

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        BigInteger aa = new BigInteger(a);
        BigInteger bb = new BigInteger(b);

        System.out.println(aa.add(bb));
        System.out.println(aa.subtract(bb));
        System.out.println(aa.multiply(bb));
    }
}
