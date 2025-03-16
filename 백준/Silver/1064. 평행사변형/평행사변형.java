import java.util.Scanner;

public class Main {

    static Point[] arr;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        arr = new Point[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }

        double first = calc(0, 1, 2);
        double second = calc(1, 0, 2);
        double third = calc(2, 0, 1);

        double max = Math.max(Math.max(first, second), third);
        double min = Math.min(Math.min(first, second), third);

        if(max == -1.0 && min == -1.0) System.out.println(-1.0);
        else System.out.println(max - min);

    }

    static double calc(int i, int j, int k) {

        Point center = arr[i];
        Point first = arr[j];
        Point second = arr[k];

        // 기울기가 같다면 평행사변형 못 만듦
        if(( center.x * first.y + first.x * second.y + second.x  * center.y ) - ( first.x * center.y + second.x * first.y + center.x * second.y) == 0) return -1.0;

        Point newPoint = new Point(first.x + (second.x - center.x), first.y + (second.y - center.y));

        return (Math.sqrt(Math.pow(newPoint.x - first.x, 2) + Math.pow(newPoint.y - first.y, 2)) + Math.sqrt(Math.pow(newPoint.x - second.x, 2) + Math.pow(newPoint.y - second.y, 2))) * 2.0;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}