import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> col = new ArrayList<>();
        col.add("black");   col.add("brown");   col.add("red");
        col.add("orange");   col.add("yellow");   col.add("green");
        col.add("blue");   col.add("violet");   col.add("grey");   col.add("white");

        String valString = "";

        for (int i = 0; i < 2; i++) {
            String color = scanner.nextLine();
            valString += col.indexOf(color);
        }

        String color = scanner.nextLine();
        for (int i = 0; i < col.indexOf(color); i++) {
            valString += "0";
        }

        for (int i = 0; i < valString.length(); i++) {
            if(valString.charAt(0) == '0') {
                valString = valString.substring(1);
            }else{
                break;
            }
        }

        if(valString.replace("0","").length() > 0){
            System.out.println(valString);
        }else {
            System.out.println(0);
        }

    }
}