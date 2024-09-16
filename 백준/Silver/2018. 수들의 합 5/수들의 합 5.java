import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;
        int result = 1;

        while (end_idx < n) {
            if (sum == n) {
                result++;
                end_idx ++;
                sum += end_idx;
            } else if (sum < n) {
                end_idx ++;
                sum += end_idx;
            } else {
                sum -= start_idx;
                start_idx ++;
            }
        }

        System.out.println(result);
    }
}


