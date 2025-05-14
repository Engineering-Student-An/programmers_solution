import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long x1 = scanner.nextLong();
        long y1 = scanner.nextLong();
        long x2 = scanner.nextLong();
        long y2 = scanner.nextLong();
        long x3 = scanner.nextLong();
        long y3 = scanner.nextLong();
        long x4 = scanner.nextLong();
        long y4 = scanner.nextLong();

        int ccw_123 = ccw(x1, y1, x2, y2, x3, y3);
        int ccw_124 = ccw(x1, y1, x2, y2, x4, y4);
        int ccw_341 = ccw(x3, y3, x4, y4, x1, y1);
        int ccw_342 = ccw(x3, y3, x4, y4, x2, y2);
        if(ccw_123 * ccw_124 == 0 && ccw_341 * ccw_342 == 0) {
            if(Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2) &&
                    Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else if(ccw_123 * ccw_124 <= 0 && ccw_341 * ccw_342 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {

        long ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x3 * y2 + x2 * y1 + x1 * y3);
        if(ccw > 0) return 1;
        else if(ccw == 0) return 0;
        else return -1;
    }
}