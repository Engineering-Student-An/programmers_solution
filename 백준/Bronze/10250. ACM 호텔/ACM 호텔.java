
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int i=0;i<t;i++) {
            int h = scanner.nextInt(); int w = scanner.nextInt(); int n = scanner.nextInt();

            int floor = 0;
            if(n%h == 0) {
                floor = (h*100) + (n/h);
            } else{
                floor = (n % h) * 100 + (n/h) + 1;
            }


            System.out.println(floor);
        }
    }
}