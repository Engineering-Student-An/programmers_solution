import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int count[] = new int[2];
        char ind = '2';

        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i) != ind){
                count[(int) (n.charAt(i)-'0')] ++;
                ind = n.charAt(i);
            }
        }

        System.out.println(Math.min(count[0], count[1]));
    }
}