import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < string.length(); i++) {
            if(arr[(int)(string.charAt(i)-'a')] == -1){
                arr[(int)(string.charAt(i)-'a')] = i;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}