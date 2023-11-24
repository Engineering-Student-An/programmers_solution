
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hour = scanner.nextInt();
        int min = scanner.nextInt();

        if(min<45) {
            min = min - 45 + 60;
            if(hour == 0){
                hour = 23;
            } else{
                hour--;
            }
        } else{
            min = min - 45;
        }


        System.out.println(hour + " " + min);
    }
}