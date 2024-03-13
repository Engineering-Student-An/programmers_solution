import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        StringBuffer one = new StringBuffer(scanner.next());
        StringBuffer two = new StringBuffer(scanner.next());

        String first = one.reverse().toString();
        String second = two.reverse().toString();

        String[] twoOfThem = {first, second};

        Arrays.sort(twoOfThem);

        System.out.print(twoOfThem[1]);

    }
}