import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();

        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        int n = num.length();
        for (int i = 0; i < n-1; i++) {
            int max = arr[i];
            int swap_ind = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    swap_ind = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[swap_ind];
            arr[swap_ind] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
}