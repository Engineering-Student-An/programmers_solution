import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextInt();
        long m = scanner.nextInt();

        long num = m/n;

        ArrayList<Long> yaksu = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if(num%i == 0) yaksu.add((long) i);
        }
//
//        if(yaksu.size()%2 != 0) {
//            yaksu.remove(yaksu.size()/2);
//        }

        long resultA = 0;
        long resultB = 0;


        for (int i = yaksu.size()/2; i < yaksu.size(); i++) {

            if(siroso(yaksu.get(i), yaksu.get(yaksu.size() - i - 1))) {
                resultA = yaksu.get(yaksu.size() - i - 1);
                resultB = yaksu.get(i);
                break;
            }

        }
        System.out.println(resultA * n + " " + resultB * n);
    }

    private static boolean siroso(long max, long min) {

        while(min>0) {
            long temp = max % min;
            max = min;
            min = temp;
        }
        return max == 1;
    }
}