import java.util.Scanner;

public class Main {
    public static int sum(int[] remain, int min_index) {
        int sum=0;
        for(int i=0;i<=min_index;i++){
            sum+=remain[i];
        }
        return sum;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        int[] remain = new int[101];
        int min_index=0, sum;
        remain[0]=64;


        while(true){
            sum = sum(remain, min_index);
            if(sum<=x) break;

            remain[min_index]/=2;
            if(sum-remain[min_index] < x){
                min_index++;
                remain[min_index] = remain[min_index-1];
            }
        }

        System.out.println(min_index+1);


    }
}
