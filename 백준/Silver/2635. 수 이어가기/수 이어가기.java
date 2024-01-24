import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int maxQ = 0;
        int max = -1;
        for (int i = n; i > 0; i--) {
            if (maxQ<minus(n, i, 2)){
                maxQ = minus(n, i, 2);
                max = i;
            }
        }
        int first = n;
        int second = max;
        System.out.println(maxQ);
        System.out.print(first + " " + second);
        while(first - second >= 0){
            System.out.print(" " + (first-second));
            int temp = first;
            first = second;
            second = temp - second;
        }

    }

    public static int minus(int first, int second, int quantity) {
        if(first-second < 0){
            return quantity;
        }
        return minus(second, first - second, quantity + 1);
    }
}
