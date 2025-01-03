import java.util.Scanner;

public class Main {

    static int n;
    static int[] num;
    static int[] op;
    static long min = Integer.MAX_VALUE;
    static long max = Integer.MIN_VALUE;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }

        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = scanner.nextInt();
        }

        long result = num[0];
        calc(result, 0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void calc(long result, int count) {

        if(count == n-1) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(op[i] > 0) {
                op[i] --;
                if(i == 0) {
                    calc(result + num[count + 1], count + 1);
                } else if (i == 1) {
                    calc(result - num[count + 1], count + 1);
                } else if (i == 2) {
                    calc(result * num[count + 1], count + 1);
                } else {
                    calc(result / num[count + 1], count + 1);
                }
                op[i] ++;
            }
        }
    }
}