import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        int[] arr = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
        }

        Arrays.sort(arr);
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}