import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int ans = 1;
        for (int i = 1; i < n; i++) {
            int sum = i;
            for (int j = i+1; j < n; j++) {
                sum += j;
                if(sum > n) {
                    break;
                } else if(sum == n) {
                    ans ++;
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}