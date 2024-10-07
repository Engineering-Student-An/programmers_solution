import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[8];
        int[] ind = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = scanner.nextInt();
            ind[i] = i+1;
        }

        for (int i = 0; i < 7; i++) {
            int max = arr[i];
            int index = i;
            for (int j = i+1; j < 8; j++) {
                if(max < arr[j]) {
                    index = j;
                    max = arr[j];
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;

            temp = ind[i];
            ind[i] = ind[index];
            ind[index] = temp;
        }

        int sum = 0;
        int[] result = new int[5];
        for (int i = 0; i < 5; i++) {
            sum += arr[i];
            result[i] = ind[i];

        }
        System.out.println(sum);

        Arrays.sort(result);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}