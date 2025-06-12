import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();

        int n = line.length();
        Integer[] arr = new Integer[n];

        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = line.charAt(i) - '0';
            sum += arr[i];
            if(arr[i] == 0) count ++;
        }

        if(count == 0 || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(arr, Comparator.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]);
            }
            System.out.println(sb);
        }
    }
}