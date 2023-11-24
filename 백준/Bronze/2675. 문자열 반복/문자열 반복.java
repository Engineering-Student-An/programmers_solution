
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int r = scanner.nextInt();
            String str = scanner.next();
            String answer = "";
            for(int j=0;j<str.length();j++){
               for(int k=0;k<r;k++){
                   answer += str.charAt(j);
               }
            }
            System.out.println(answer);
        }
    }
}