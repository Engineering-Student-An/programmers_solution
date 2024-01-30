import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int num_f = scanner.nextInt();
        int den_f = scanner.nextInt();
        int num_s = scanner.nextInt();
        int den_s = scanner.nextInt();

        int num = num_f * den_s + num_s * den_f;
        int den = den_f * den_s;

        int max = Math.max(num, den);
        int min = Math.min(num, den);

        while(min!=0){
            int temp = max;
            max = min;
            min = temp % min;
        }

        System.out.println(num/max + " " + den/max);

    }
}
