import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Arrays.sort(arr, Comparator.comparing((int[] o) -> o[1])
                .thenComparing((int[] o) -> o[0]));

        int count = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i][0] >= end) {
                end = arr[i][1];
                count ++;
            }
        }

        System.out.println(count);
    }
}