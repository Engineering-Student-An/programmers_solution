import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String name = scanner.next();
            int age = scanner.nextInt();
            int weight = scanner.nextInt();
            String club="";
            if(name.equals("#") && age ==0 && weight == 0) break;
            if(age > 17 || weight >= 80) club = "Senior";
            else club = "Junior";

            System.out.println(name + " " + club);
        }
    }
}