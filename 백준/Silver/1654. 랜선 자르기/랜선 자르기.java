import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        long start = 0;
        long end = arr[n-1];

        long result = -1;
        while(end>=start){
            long middle = (end + start) / 2;
            if(middle == 0) middle = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] >= middle) {
                    sum += (int) (arr[i]/middle);
                }
            }
            if(sum >= k && middle > result) {
                result = middle;
            }

            if(sum < k) {
                end = middle-1;
            } else {
                start = middle + 1;
            }

        }
        System.out.println(result);
    }

}

