import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] arr = new String[50];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        String answer = "";
        for (int i = 0; i < arr[0].length(); i++) {
            Boolean check = true;
            char charCheck = arr[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if(charCheck != arr[j].charAt(i)){
                    check=false;
                    break;
                }
            }
            if(!check) answer+="?";
            else answer += charCheck;
        }
        System.out.println(answer);
    }
}
