import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long min = scanner.nextLong();
        long max = scanner.nextLong();

        boolean[] isPow = new boolean[(int) (max - min) + 1];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;

            long startIdx = min / pow;

            for (long j = startIdx; j * pow <= max; j++) {
                if (j * pow < min) continue;

                isPow[(int) (j * pow - min)] = true;
            }
        }

        int count = 0;
        for (boolean b : isPow) {
            if(!b) count ++;
        }

        System.out.println(count);
    }
}