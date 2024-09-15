import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();

        int answer = 999999;

        long[] sum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + scanner.nextInt();
        }

        int start_idx = 0;
        int end_idx = 0;

        while(end_idx <= n) {
            long minus = sum[end_idx] - sum[start_idx];
            if(minus < s) {
                end_idx ++;
            } else if(minus >= s) {
                answer = Math.min(answer, end_idx-start_idx);
                start_idx ++;
            }
        }

        System.out.println((answer==999999) ? 0 : answer);
    }
}


