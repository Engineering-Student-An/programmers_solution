import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();


        int ccw1 = ccw(x1, y1, x2, y2, x3, y3);
        int ccw2 = ccw(x1, y1, x2, y2, x4, y4);
        int ccw3 = ccw(x3, y3, x4, y4, x1, y1);
        int ccw4 = ccw(x3, y3, x4, y4, x2, y2);
        int result1 = ccw1 * ccw2;
        int result2 = ccw3 * ccw4;

        if(result1 == 0 && result2 == 0) {
            System.out.println(isOverlap(x1, y1, x2, y2, x3, y3, x4, y4) ? 1 : 0);
        } else if(result1 <= 0 && result2 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static boolean isOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        if(Math.max(x1, x2) < Math.min(x3, x4) || Math.max(x3, x4) < Math.min(x1, x2) ||
                Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) return false;
        return true;
    }

    static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long result = ((long) x1 * y2 + (long) x2 * y3 + (long) x3 * y1) - ((long) x2 * y1 + (long) x3 * y2 + (long) x1 * y3);
        if(result < 0) return -1;
        else if(result > 0) return 1;
        else return 0;
    }
}