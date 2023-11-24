
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        for(int i=1;i<=9;i++){
            arr[i]= scanner.nextInt();
        }
        int max=0;
        int index=0;
        for (int i = 1; i <= 9; i++) {
            if(max<arr[i]){
                max=arr[i];
                index=i;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}