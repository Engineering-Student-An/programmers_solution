import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();
            if(str.equals("#")) break;
            str = str.toLowerCase();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' ||
                        str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
