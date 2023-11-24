import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int finish = scanner.nextInt();

        int[] arr = new int[finish + 1];
        int count = 0;
        int num=1;
        for (int i = 1; i <= finish; i++) {
            if (count == num) {
                count = 0;
                num++;
            }
            arr[i]=num;
            count++;
        }
        int sum=0;
        for (int i = start; i <= finish; i++) {
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}