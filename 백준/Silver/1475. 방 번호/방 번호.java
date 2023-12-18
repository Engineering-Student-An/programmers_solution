import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();

        int[] arr = new int[10];

        for (int i = 0; i < num.length(); i++) {
            arr[(int)(num.charAt(i) - '0')] ++;
        }

        while(Math.abs(arr[6]-arr[9]) > 1){
            if (arr[6] > arr[9]) {
                arr[9] ++;
                arr[6] --;
            } else if (arr[9] > arr[6]) {
                arr[6] ++;
                arr[9] --;
            }
        }


        int max = -1;
        for (int i : arr) {
            max = Math.max(max,i);
        }
        System.out.println(max);
    }
}