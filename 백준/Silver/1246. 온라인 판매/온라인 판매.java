import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        int max = -1;
        int cost = -1;
        for (int i = 0; i < m; i++) {
            int allCost = (n>m-i) ? (m-i) * arr[i] : n * arr[i];
            if(max<allCost){
                cost = arr[i];
                max = allCost;
            }
        }
        System.out.println(cost + " " + max);
    }
}