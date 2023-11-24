import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr= new int[42];
        for (int i = 0; i < 10; i++) {
            int n = scanner.nextInt();
            arr[n%42] = 1;
        }

        int count = 0;
        for (int i = 0; i < 42; i++) {
            if(arr[i] == 1) count++;
        }
        System.out.println(count);
    }
}