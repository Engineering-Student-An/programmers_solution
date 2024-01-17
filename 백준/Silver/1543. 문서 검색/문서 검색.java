import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String full = scanner.nextLine();
        String find = scanner.nextLine();
        int count = 0;
        while(full.contains(find)){
            count ++;
            int index = full.indexOf(find);
            full = full.substring(index+find.length());
        }
        System.out.println(count);
    }
}