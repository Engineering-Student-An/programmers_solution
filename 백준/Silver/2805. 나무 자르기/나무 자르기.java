import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr[n-1];

        long result = -1;
        while(end>=start){
            int middle = (end + start) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] >= middle) {
                    sum += (arr[i]-middle);
                }
            }
            if(sum >= m) {
                result = middle;
            }
            if(m == sum) {
                break;
            }

            if(sum < m) {
                end = middle-1;
            } else {
                start = middle + 1;
            }

        }
        System.out.println(result);
    }

}

