import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int newScore = scanner.nextInt();
        int p = scanner.nextInt();
        int[] arr = new int [p+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = n + 1; i <= p; i++ ) {
            arr[i] = -1;
        }

        int index = -1;
        for (int i = 1; i <= p; i++) {
            if(newScore > arr[i]){
                index = i;
                break;
            }
        }
        if(index == -1) {
            System.out.println(index);
        } else {
            int minus = 0;
            for (int i = 1; i < index; i++) {
                if(arr[i] == newScore) minus++;
            }
            System.out.println(index-minus);
        }
    }
}