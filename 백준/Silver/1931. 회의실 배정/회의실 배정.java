import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextLong();
            }
        }

        Arrays.sort(arr, Comparator.comparing((long[] o) -> o[1])
                .thenComparing((long[] o) -> o[0]));

        long end = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i][0] >= end){
                count ++;
                end = arr[i][1];
            }
        }

        System.out.println(count);
    }
}

